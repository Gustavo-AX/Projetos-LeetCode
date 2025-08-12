var isDigit = function(c) {
    return c >= '0' && c <= '9';
};

var myAtoi = function(s) {
	let string = s;
	let substring = "";
	let signal = true;
	
	let state = 0;
	/*
	state = 0 -> blank
	state = 1 -> signal
	state = 2 -> zero
	state = 3 -> digit
	state = 4 -> end
	*/
	
	for (let i = 0; i < string.length; i++){
		switch(state){
		
		case 0:
			if(string.charAt(i) === ' '){
				//Do nothing
			} else {
				state = 1;
				i--;
			}
			break;
			
		case 1:
			if(string.charAt(i) === '+'){
				state = 2;
			} else if (string.charAt(i) === '-'){
				signal = false;
				state = 2;
			} else {
				state = 2;
				i--;
			}
			break;
			
		case 2: 
			if(string.charAt(i) === '0'){
				//Do nothing
			} else {
				state = 3;
				i--;
			}
			break;
		
		case 3: 
			if(isDigit(string.charAt(i))){
				substring += string.charAt(i);
			} else {
				state = 4;
				i--;
			}
			break;
		
		case 4:
			//here, we just end the loop:
			i =  string.length;
			break;
			
		default:
			i =  string.length;
			break;
		}
		
	}
	
	//Here we have a substring formed just by numbers. Now we will sum this number, using 10^i
	
	let number = 0;
	for(let i = 0; i < substring.length; i++){
		number +=substring.charAt(substring.length - i - 1) * (10 ** i)
	}
	
	if(signal){
		// Do nothing
	} else {
		number *= -1;
	}
	
	// Limite do int:
	const INT_MAX = 2147483647;
    	const INT_MIN = -2147483648;
	if (number > INT_MAX) return INT_MAX;
    	if (number < INT_MIN) return INT_MIN;
	
	return number;
};
