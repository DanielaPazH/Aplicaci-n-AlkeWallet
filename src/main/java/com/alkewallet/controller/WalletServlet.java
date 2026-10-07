 package com.alkewallet.controller;

import java.io.IOException;

import com.alkewallet.model.cuenta;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/wallet")
public class WalletServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private cuenta cuenta = new cuenta();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("saldo", cuenta.getSaldo());
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        String montoTexto = request.getParameter("monto");
        String mensaje;

        try {
            double monto = Double.parseDouble(montoTexto);

            if ("depositar".equals(accion)) {
                cuenta.depositar(monto);
                mensaje = "Deposito realizado correctamente.";

            } else if ("retirar".equals(accion)) {

                if (cuenta.retirar(monto)) {
                    mensaje = "Retiro realizado correctamente.";
                } else {
                    mensaje = "No tienes saldo suficiente o el monto no es valido.";
                }

            } else {
                mensaje = "Operacion no valida.";
            }

        } catch (NumberFormatException e) {
            mensaje = "Ingresa un monto valido.";
        }

        request.setAttribute("saldo", cuenta.getSaldo());
        request.setAttribute("mensaje", mensaje);

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}