$(function() {

    var owner = $('#' + portletNamespace + 'owner');
    
    var cardNumber = $('#' + portletNamespace + 'cardNumber');
    
    console.log(cardNumber);
    
    var cardNumberField = $('#card-number-field');
    
    var CVV = $('#' + portletNamespace + 'cvv');
    var mastercard = $("#mastercard");
    var confirmButton = $('#' + portletNamespace + 'Buy');
    var visa = $("#visa");

    // Use the payform library to format and validate
    // the payment fields.

    cardNumber.payform('formatCardNumber');
    CVV.payform('formatCardCVC');


    cardNumber.keyup(function() {
    	
    	visa.addClass('transparent');
    	mastercard.addClass('transparent');

        if ($.payform.validateCardNumber(cardNumber.val()) == false) {
            cardNumberField.addClass('has-error');
        } else {
            cardNumberField.removeClass('has-error');
            cardNumberField.addClass('has-success');
        }

        if ($.payform.parseCardType(cardNumber.val()) == 'visa') {
            visa.removeClass('transparent');
        } else if ($.payform.parseCardType(cardNumber.val()) == 'mastercard') {
            mastercard.removeClass('transparent');
        }
    });

    confirmButton.click(function(e) {

//        e.preventDefault();

        var isCardValid = $.payform.validateCardNumber(cardNumber.val());
        var isCvvValid = $.payform.validateCardCVC(CVV.val());

        if (!isCardValid) {
            e.preventDefault();
            alert("Wrong card number");
        } else if (!isCvvValid) {
            e.preventDefault();
            alert("Wrong CVV");
        } else {
            // Everything is correct. Add your form submission code here.
//            alert("Everything is correct");
        }
    });
});
