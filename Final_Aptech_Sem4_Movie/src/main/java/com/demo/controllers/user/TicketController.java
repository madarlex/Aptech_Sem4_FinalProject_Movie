package com.demo.controllers.user;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.demo.models.Account;
import com.demo.models.AvailableSeats;
import com.demo.models.ConfirmedPayment;
import com.demo.models.Email;
import com.demo.models.Hall;
import com.demo.models.Movie;
import com.demo.models.Movieshowtime;
import com.demo.models.Price;
import com.demo.models.Seat;
import com.demo.models.Ticket;
import com.demo.models.TicketPriceDetail;
import com.demo.paypal.PayPalConfig;
import com.demo.paypal.PayPalResult;
import com.demo.paypal.PayPalSucess;
import com.demo.services.AccountService;
import com.demo.services.HallService;
import com.demo.services.MailService;
import com.demo.services.MovieshowtimeService;
import com.demo.services.PayPalService;
import com.demo.services.PriceService;
import com.demo.services.SeatService;
import com.demo.services.TicketPriceDetailService;
import com.demo.services.TicketService;




@Controller
@RequestMapping({"ticket"})
public class TicketController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private PriceService priceService;
	
	@Autowired
	private MovieshowtimeService movieshowtimeService;
	
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private TicketPriceDetailService ticketPriceDetailService;
	
	@Autowired
	private SeatService seatService;
	
	@Autowired
	private HallService hallService;
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private PayPalService payPalService;
	
	@Autowired
	private MailService mailService;
	
	@RequestMapping(value={"index"}, method=RequestMethod.GET)
	public String index(Principal principal, ModelMap modelMap, HttpSession session, @ModelAttribute("selectedSeat") AvailableSeats selectedSeat, @RequestParam String movieShowTimeId) {
		System.out.println(movieShowTimeId);
		if (movieShowTimeId.isEmpty()) {
			System.out.println(movieShowTimeId);
			return "home/index";
		} else {

			Movieshowtime chosenMovieShowTime = movieshowtimeService.findById(Integer.parseInt(movieShowTimeId));
			Price chosenPrice = priceService.findByDescription(chosenMovieShowTime.getShowDate());
			session.setAttribute("chosenPrice", chosenPrice);
			session.setAttribute("chosenMovieShowTime", chosenMovieShowTime);
			List<AvailableSeats> availableSeats = (List<AvailableSeats>) seatService.getAvailableSeats(chosenMovieShowTime.getHall().getId(), chosenMovieShowTime.getId());
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
	}
	
	@RequestMapping(value = "continueBookingTicket", method = RequestMethod.GET)
	public String continueBookingTicket(HttpSession session, ModelMap modelMap, @RequestParam("bookingSeats[]") Integer[] bookingSeats) {
		Price chosenPrice = (Price) session.getAttribute("chosenPrice");
		double ticketPrice = chosenPrice.getPrice();
		double paymentAmount = bookingSeats.length * ticketPrice;
		modelMap.put("ticketPrice", ticketPrice);
		modelMap.put("paymentAmount", paymentAmount);
		modelMap.put("seatNumber", bookingSeats.length);
		session.setAttribute("bookingSeats", bookingSeats);
		session.setAttribute("chosenPrice", chosenPrice);
		String business = environment.getProperty("paypal.business");
		String returnUrl = environment.getProperty("paypal.returnurl");
		String postUrl = environment.getProperty("paypal.posturl");
		modelMap.put("business", business);
		modelMap.put("returnUrl", returnUrl);
		modelMap.put("postUrl", postUrl);
		return "ticket/ticketbookingpayment";
	}
	
	@RequestMapping(value={"success"}, method=RequestMethod.GET)
	public String success(HttpSession session, HttpServletRequest request, Principal principal) {
		Integer[] bookingSeats = (Integer[]) session.getAttribute("bookingSeats");
		Movieshowtime chosenMovieShowTime = (Movieshowtime) session.getAttribute("chosenMovieShowTime");
		Price chosenPrice = (Price) session.getAttribute("chosenPrice");
		String currentUsername = principal.getName();

		Account currentAccount = accountService.findByUsername(currentUsername);

		Hall hall = chosenMovieShowTime.getHall();
		List<String> seatPositions = new ArrayList<String>();
		for (Integer bookingSeat : bookingSeats) {
			Seat seat = seatService.findById(bookingSeat);
			seatPositions.add(seat.getPosition());
			Ticket ticket = new Ticket();
			ticket.setAccount(currentAccount);
			ticket.setSeat(seat);
			ticket.setHall(hall);
			ticket.setMovieshowtime(chosenMovieShowTime);
			ticket.setStatus(true);
			ticketService.save(ticket);
			TicketPriceDetail ticketPriceDetail = new TicketPriceDetail();
			ticketPriceDetail.setTicket(ticket);
			ticketPriceDetail.setPrice(chosenPrice);
			
			ticketPriceDetailService.save(ticketPriceDetail);
			
			
		}
		String seatPositionsFlatten = String.join(", ", seatPositions); 
		PayPalConfig payPalConfig = payPalService.getPayPalConfig();
		PayPalResult result = PayPalSucess.getPayPal(request, payPalConfig);

		Map<String,Object> model = new HashMap<>();
		model.put("full_name", currentAccount.getFullName());
		Email email = new Email();
		email.setTo(currentAccount.getEmail());
		email.setFrom(environment.getProperty("spring.mail.username"));
		email.setModel(model);
		email.setSubject("Book Ticket");
		model.put("header", "Successful Book Ticket");
		model.put("content", "This is an email to notify you that your ticket has been successfully purchased, if you have any questions, please contact customer support.");
		try {
			mailService.send(email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "ticket/success";
	}

}
