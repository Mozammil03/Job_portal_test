package com.example.demo.utility;

import com.example.demo.model.OTP;

public class Data {
    public static String getMessageBody(String otp){
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "  <head>\n" +
                "    <meta charset=\"UTF-8\" />\n" +
                "    <title>OTP Verification</title>\n" +
                "  </head>\n" +
                "  <body style=\"margin:0; padding:0; background-color:#f6f6f6; font-family: Arial, sans-serif;\">\n" +
                "    <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"background-color:#f6f6f6; padding:40px 0;\">\n" +
                "      <tr>\n" +
                "        <td align=\"center\">\n" +
                "          <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"max-width:600px; background-color:#ffffff; border-radius:8px; overflow:hidden;\">\n" +
                "            <!-- Header -->\n" +
                "            <tr>\n" +
                "              <td style=\"background-color:#f99b07; padding:20px 30px; text-align:center;\">\n" +
                "                <h1 style=\"margin:0; color:#ffffff; font-size:24px;\">Verify Your Email</h1>\n" +
                "              </td>\n" +
                "            </tr>\n" +
                "\n" +
                "            <!-- Body -->\n" +
                "            <tr>\n" +
                "              <td style=\"padding:30px;\">\n" +
                "                <p style=\"font-size:16px; color:#4f4f4f; margin-bottom:16px;\">Hi there,</p>\n" +
                "                <p style=\"font-size:16px; color:#4f4f4f; margin-bottom:16px;\">Your one-time password (OTP) for verifying your email is:</p>\n" +
                "                <div style=\"text-align:center; margin:20px 0;\">\n" +
                "                  <span style=\"display:inline-block; background-color:#ffe588; color:#2d2d2d; font-size:32px; font-weight:bold; letter-spacing:8px; padding:10px 20px; border-radius:6px;\">\n" +
                "                    "+ otp + "\n" +
                "                  </span>\n" +
                "                </div>\n" +
                "                <p style=\"font-size:14px; color:#5d5d5d; margin-bottom:12px;\">\n" +
                "                  This OTP is valid for 10 minutes. Please do not share it with anyone.\n" +
                "                </p>\n" +
                "                <p style=\"font-size:14px; color:#5d5d5d;\">\n" +
                "                  If you didn't request this OTP, you can safely ignore this email.\n" +
                "                </p>\n" +
                "              </td>\n" +
                "            </tr>\n" +
                "\n" +
                "            <!-- Footer -->\n" +
                "            <tr>\n" +
                "              <td style=\"background-color:#e7e7e7; padding:20px 30px; text-align:center;\">\n" +
                "                <p style=\"margin:0; font-size:12px; color:#6d6d6d;\">\n" +
                "                  &copy; 2025 Your Company. All rights reserved.\n" +
                "                </p>\n" +
                "              </td>\n" +
                "            </tr>\n" +
                "          </table>\n" +
                "        </td>\n" +
                "      </tr>\n" +
                "    </table>\n" +
                "  </body>\n" +
                "</html>";

    }
}
