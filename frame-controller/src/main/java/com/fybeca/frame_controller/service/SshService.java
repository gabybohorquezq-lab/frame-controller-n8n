package com.fybeca.frame_controller.service;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.springframework.stereotype.Service;
import java.io.InputStream;

@Service
public class SshService {

    public String ejecutarScript(String ip, String usuario, String password, String rutaShell, String servicio) {
        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(usuario, ip, 22);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();

            ChannelExec channel = (ChannelExec) session.openChannel("exec");
            // Aquí unimos el script con el nombre del servicio
            String comandoFinal = "sh " + rutaShell + (servicio != null && !servicio.isEmpty() ? " " + servicio : "");
            channel.setCommand(comandoFinal);

            channel.setInputStream(null);
            InputStream in = channel.getInputStream();
            channel.connect();

            byte[] tmp = new byte[1024];
            StringBuilder resultado = new StringBuilder();
            while (true) {
                while (in.available() > 0) {
                    int i = in.read(tmp, 0, 1024);
                    if (i < 0) break;
                    resultado.append(new String(tmp, 0, i));
                }
                if (channel.isClosed()) break;
            }
            channel.disconnect();
            session.disconnect();
            return resultado.toString();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}