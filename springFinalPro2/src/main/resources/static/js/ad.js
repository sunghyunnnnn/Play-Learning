
				const bestTxtSwiper = new Swiper(".best-txt-slider", {
			autoplay: {
				delay: 4000,
				disableOnInteraction: false,
			},
			effect: "fade",
			loop: true,
			allowTouchMove: false,
		});
		
		const bestSwiper = new Swiper(".best-slider", {
			autoplay: {
				delay: 4000,
				disableOnInteraction: false,
			},
			slidesPerView: 1.4,
			loop: true,
			navigation: {
				nextEl: ".best-slider .swiper-button-next",
				prevEl: ".best-slider .swiper-button-prev",
			},
			on: {
			slideChangeTransitionStart: function () {
				const realIndex = bestSwiper.realIndex;
				let targetIndex = realIndex;
		
				bestTxtSwiper.slideTo(targetIndex);
				bestTxtSwiper.update(); // swiper업데이트 
			},
			slideNextTransitionStart: function () {
				bestTxtSwiper.autoplay.stop(); // 
			},
			slidePrevTransitionStart: function () {
				bestTxtSwiper.autoplay.stop(); // 
			},
			slideChangeTransitionEnd: function () {
				bestTxtSwiper.autoplay.start(); // 
			}
		}
		
		});
		
	