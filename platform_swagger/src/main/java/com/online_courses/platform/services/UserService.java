package com.online_courses.platform.services;
import com.online_courses.platform.repositories.UserRepository;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.online_courses.platform.models.User;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.mail.internet.MimeMessage;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;
    @Value("${spring.mail.username}")
    private String fromAddress;

    public UserService(JavaMailSender mailSender, UserRepository userRepository, TemplateEngine templateEngine) {
        this.mailSender = mailSender;
        this.userRepository = userRepository;
        this.templateEngine = templateEngine;
    }
/*
    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo(to);
        mensaje.setSubject(subject);
        mensaje.setText(text);
        mensaje.setFrom("SoyPepitoElGrillo@hotmail.com");

        mailSender.send(mensaje);
    }
 */
    public User newUser(User user){
        User u= new User();
        u.setName(user.getName());
        u.setEmail(user.getEmail());
        u.setPasswordHash(user.getPasswordHash());
        u.setIdRole(2);
        User savedUser = userRepository.save(u);
        try {
            sendWelcomeEmail(savedUser);
        } catch (Exception e) {
            logger.error("El usuario se registro, pero fallo el envio del correo de bienvenida a {}", savedUser.getEmail(), e);
        }
        return savedUser;
    }

    public void sendWelcomeEmail(User user) {
        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new IllegalArgumentException("El correo del usuario es obligatorio para enviar la bienvenida");
        }

        try {
            Context context = new Context();
            context.setVariable("name", user.getName());

            String htmlBody = templateEngine.process("PlantillaCorreoNuevoUsuario", context);

            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");
            helper.setTo(user.getEmail().trim());
            helper.setSubject("Bienvenido a la plataforma de cursos en linea");
            helper.setText(htmlBody, true);
            helper.setFrom(fromAddress);

            mailSender.send(mimeMessage);
        } catch (Exception e) {
            logger.error("No se pudo enviar el correo de bienvenida a {}", user.getEmail(), e);
            throw new RuntimeException("No se pudo enviar el correo de bienvenida", e);
        }
    }
}
