package com.demo.controllers.user;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.models.AvailableSeats;
import com.demo.models.ConfirmedPayment;
import com.demo.paypal.PayPalConfig;
import com.demo.paypal.PayPalResult;
import com.demo.paypal.PayPalSucess;
import com.demo.services.PayPalService;
import com.demo.services.SeatService;
import com.demo.services.TicketService;




@Controller
@RequestMapping({"ticket"})
public class TicketController {

	
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private SeatService seatService;
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private PayPalService payPalService;
//	
//	@Autowired
//	private MailService mailService;
	
	@RequestMapping(value={"index"}, method=RequestMethod.GET)
	public String index(ModelMap modelMap, HttpSession session, @ModelAttribute("selectedSeat") AvailableSeats selectedSeat) {
//		Account account = (Account) session.getAttribute("account");
		int movie_show_time_id = 1;
		int hall_id = 1;
		List<AvailableSeats> availableSeats = (List<AvailableSeats>) seatService.getAvailableSeats(hall_id, movie_show_time_id);
		List<AvailableSeats> availableSeats_A = new ArrayList<AvailableSeats>();
		List<AvailableSeats> availableSeats_B = new ArrayList<AvailableSeats>();
		List<AvailableSeats> availableSeats_C = new ArrayList<AvailableSeats>();
		List<AvailableSeats> availableSeats_D = new ArrayList<AvailableSeats>();
		List<AvailableSeats> availableSeats_E = new ArrayList<AvailableSeats>();
		List<AvailableSeats> availableSeats_F = new ArrayList<AvailableSeats>();
		List<AvailableSeats> availableSeats_G = new ArrayList<AvailableSeats>();
		List<AvailableSeats> availableSeats_H = new ArrayList<AvailableSeats>();
		List<AvailableSeats> availableSeats_I = new ArrayList<AvailableSeats>();
		List<AvailableSeats> availableSeats_J = new ArrayList<AvailableSeats>();
		for (AvailableSeats availableSeat : availableSeats) {
			if (availableSeat.getPosition().substring(0,1).equals("A")) {
				availableSeats_A.add(availableSeat);
			} else if (availableSeat.getPosition().substring(0,1).equals("B")) {
				availableSeats_B.add(availableSeat);
			} else if (availableSeat.getPosition().substring(0,1).equals("C")) {
				availableSeats_C.add(availableSeat);
			} else if (availableSeat.getPosition().substring(0,1).equals("D")) {
				availableSeats_D.add(availableSeat);
			} else if (availableSeat.getPosition().substring(0,1).equals("E")) {
				availableSeats_E.add(availableSeat);
			} else if (availableSeat.getPosition().substring(0,1).equals("F")) {
				availableSeats_F.add(availableSeat);
			} else if (availableSeat.getPosition().substring(0,1).equals("G")) {
				availableSeats_G.add(availableSeat);
			} else if (availableSeat.getPosition().substring(0,1).equals("H")) {
				availableSeats_H.add(availableSeat);
			} else if (availableSeat.getPosition().substring(0,1).equals("I")) {
				availableSeats_I.add(availableSeat);
			} else {
				availableSeats_J.add(availableSeat);
			}
		}
		modelMap.put("availableSeats_A", availableSeats_A);
		modelMap.put("availableSeats_B", availableSeats_B);
		modelMap.put("availableSeats_C", availableSeats_C);
		modelMap.put("availableSeats_D", availableSeats_D);
		modelMap.put("availableSeats_E", availableSeats_E);
		modelMap.put("availableSeats_F", availableSeats_F);
		modelMap.put("availableSeats_G", availableSeats_G);
		modelMap.put("availableSeats_H", availableSeats_H);
		modelMap.put("availableSeats_I", availableSeats_I);
		modelMap.put("availableSeats_J", availableSeats_J);
		return "ticket/index";
	}
	
	@RequestMapping(value = "continueBookingTicket", method = RequestMethod.GET)
	public String continueBookingTicket(HttpSession session, ModelMap modelMap, @RequestParam("bookingSeats[]") Integer[] bookingSeats) {
		double ticketPrice = 10;
		double paymentAmount = bookingSeats.length * ticketPrice;
		modelMap.put("ticketPrice", ticketPrice);
		modelMap.put("paymentAmount", paymentAmount);
		modelMap.put("seatNumber", bookingSeats.length);
		session.setAttribute("bookingSeats", bookingSeats);
		session.setAttribute("bookingSeats", bookingSeats);
		String business = environment.getProperty("paypal.business");
		String returnUrl = environment.getProperty("paypal.returnurl");
		String postUrl = environment.getProperty("paypal.posturl");
		modelMap.put("business", business);
		modelMap.put("returnUrl", returnUrl);
		modelMap.put("postUrl", postUrl);
		return "ticket/ticketbookingpayment";
	}
	
	@RequestMapping(value={"success"}, method=RequestMethod.GET)
	public String success(HttpServletRequest request) {
		
		PayPalConfig payPalConfig = payPalService.getPayPalConfig();
		PayPalResult result = PayPalSucess.getPayPal(request, payPalConfig);
		System.out.println("first name: " + result.getFirst_name());
		System.out.println("last name: " + result.getLast_name());
		System.out.println("street: " + result.getAddress_street());
		return "ticket/success";
	}
}
