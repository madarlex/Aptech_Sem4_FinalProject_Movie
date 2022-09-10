package com.demo.services;

public interface MailService {

		public void send(String from, String to, String subject, Object content) throws Exception;
}
