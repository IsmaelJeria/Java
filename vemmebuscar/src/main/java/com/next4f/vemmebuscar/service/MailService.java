package com.next4f.vemmebuscar.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.next4f.vemmebuscar.domain.ArrivalEnum;
import com.next4f.vemmebuscar.domain.Customer;
import com.next4f.vemmebuscar.domain.PurchaseOrder;
import com.next4f.vemmebuscar.domain.Transfer;
import com.next4f.vemmebuscar.resource.request.CustomerRequest;
import com.next4f.vemmebuscar.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;


@Service
public class MailService {
    @Value("${agency-mail}")
    private String agencyMail;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private SpringTemplateEngine templateEngine;

    public void sendMail(String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("teste@ubatubaevoce.com.br");
        message.setTo("ignaciovl.j@gmail.com");
        message.setSubject("subject");
        message.setText(body);
        mailSender.send(message);
    }


    @Async
    public void sendCustomerEmail(CustomerRequest customerRequest, PurchaseOrder purchaseOrder) throws MessagingException {

        String subject = "Reserva Confirmada";

        String rdate = null;
        String rHour = null;

        String hour = null;

        String date = null;

        String adultoText = "Adulto";
        if (customerRequest.getAdults() > 1)
            adultoText = "Adultos";

        String criancaText = "Criança";
        if (customerRequest.getChildren() > 1)
            criancaText = "Crianças";

        String bebeText = "Bebê";
        if (customerRequest.getBabies() > 1)
            bebeText = "Bebês";

        Locale locale = Locale.forLanguageTag("es-CL");
        NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);


        if (customerRequest.getTransferLocalDateTime() != null) {
            hour = DateUtils.stringToLocalDateTime(customerRequest.getTransferLocalDateTime()).toLocalTime().toString();
            hour = DateUtils.stringToLocalDateTime(customerRequest.getTransferLocalDateTime()).toLocalTime().toString();
            date = DateUtils.stringToLocalDateTime(customerRequest.getTransferLocalDateTime()).toLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }

        if (customerRequest.getReturnLocalDateTime() != null) {
            rdate = DateUtils.stringToLocalDateTime(customerRequest.getReturnLocalDateTime()).toLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            rHour = DateUtils.stringToLocalDateTime(customerRequest.getReturnLocalDateTime()).toLocalTime().toString();
        }

        final Context ctx = getContext(customerRequest);

        ctx.setVariable("total", numberFormat.format(purchaseOrder.getTotalAmount().intValue()).replace(",", "."));

        ctx.setVariable("adultoText", adultoText);
        ctx.setVariable("criancaText", criancaText);
        ctx.setVariable("bebeText", bebeText);

        ctx.setVariable("hour", hour);
        ctx.setVariable("date", date);

        ctx.setVariable("rhour", rHour);
        ctx.setVariable("rdate", rdate);

        if (ctx.getVariable("wheelchair") == null)
            ctx.setVariable("wheelchair", "Não");

        if (ctx.getVariable("wheelchair") != null && ctx.getVariable("wheelchair").toString().equals("true"))
            ctx.setVariable("wheelchair", "Sim");

        if (ctx.getVariable("wheelchair") != null && ctx.getVariable("wheelchair").toString().equals("false"))
            ctx.setVariable("wheelchair", "Não");

        if (ctx.getVariable("babychair") == null)
            ctx.setVariable("babychair", "Não");

        if (ctx.getVariable("babychair") != null && ctx.getVariable("babychair").toString().equals("true"))
            ctx.setVariable("babychair", "Sim");

        if (ctx.getVariable("babychair") != null && ctx.getVariable("babychair").toString().equals("false"))
            ctx.setVariable("babychair", "Ñao");

        final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
        final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");

        message.setSubject(subject);
        message.setTo(customerRequest.getCustomerEmail());

        try {
            message.setFrom(new InternetAddress("naoresponder@vemmebuscar.com", "Vem Me Buscar"));
        } catch (UnsupportedEncodingException e) {
        }

        String htmlContent = null;

        if (customerRequest.getArrival().toString().equals("FROM_AIRPORT") && customerRequest.getTrip().toString().equals("ONE_WAY_TRIP"))
            htmlContent = this.templateEngine.process("correo-cliente-desde-ida.html", ctx);

        if (customerRequest.getArrival().toString().equals("TO_AIRPORT") && customerRequest.getTrip().toString().equals("ONE_WAY_TRIP"))
            htmlContent = this.templateEngine.process("correo-cliente-hacia-ida_vuelta.html", ctx);

        if (customerRequest.getArrival().toString().equals("FROM_AIRPORT") && customerRequest.getTrip().toString().equals("ROUND_TRIP"))
            htmlContent = this.templateEngine.process("correo-cliente-desde-ida_vuelta.html", ctx);

        if (customerRequest.getArrival().toString().equals("TO_AIRPORT") && customerRequest.getTrip().toString().equals("ROUND_TRIP"))
            htmlContent = this.templateEngine.process("correo-cliente-hacia-aeropuerto-ida.html", ctx);

        message.setText(htmlContent, true);


        this.mailSender.send(mimeMessage);
        message.setTo(agencyMail);
        message.setSubject("orden n° ".concat(purchaseOrder.getId()+""));
        this.mailSender.send(mimeMessage);

    }

    @Async
    public void sendAgencyEmail() throws MessagingException {
        String subject = "Novo relatório";

        final Context ctx = new Context(Locale.getDefault());
        ctx.setVariable("nome", "test");
        ctx.setVariable("obra", "test");
        ctx.setVariable("logo", "test");

        final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
        final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        message.setSubject(subject);
        message.setTo("ignaciovl.j@gmail.com");

        try {
            message.setFrom(new InternetAddress("teste@ubatubaevoce.com.br", "correo-cliente-desde-ida"));
        } catch (UnsupportedEncodingException e) {
        }

        final String htmlContent = this.templateEngine.process("correo-agencia", ctx);
        message.setText(htmlContent, true);

        this.mailSender.send(mimeMessage);
    }

    private Context getContext(Object obj) {

        final Context ctx = new Context(Locale.ENGLISH);

        Map map = new ObjectMapper().convertValue(obj, Map.class);

        map.forEach((key, value) -> {
            ctx.setVariable((String) key, value);
        });

        return ctx;
    }



}
