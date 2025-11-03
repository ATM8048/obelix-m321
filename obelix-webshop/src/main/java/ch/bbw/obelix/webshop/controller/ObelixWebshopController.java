package ch.bbw.obelix.webshop.controller;

import ch.bbw.obelix.webshop.dto.BasketDto;
import ch.bbw.obelix.webshop.service.BasketService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public class ObelixWebshopController {

	private final BasketService basketService;

	public ObelixWebshopController(BasketService basketService) {
		this.basketService = basketService;
	}

	@GetMapping("/api")
	public String welcome() {
		return "Welcome to Obelix's Menhir Shop! The finest menhirs in all of Gaul! Ces Romains sont fous!";
	}

	/**
	 * Customer adds even more shinies in exchange for a beautiful menhir.
	 */
	@PutMapping("/api/basket/offer")
	public BasketDto offer(@RequestBody BasketDto.BasketItem basketItem) {
		return basketService.offer(basketItem);
	}

	/**
	 * In case the customer doesn't want to offer more and leaves.
	 */
	@DeleteMapping("/api/basket")
	public void leave() {
		basketService.leave();
	}

	/**
	 * Decide if the current basket is worthy enough for a beautiful menhir.
	 *
	 * @param menhirId the menhir to buy
	 */
	@PostMapping("/api/basket/buy/{menhirId}")
	public void exchangeFor(@PathVariable UUID menhirId) {
		basketService.exchange(menhirId);
	}
}
