String.format = function (s) {var a = Array.prototype.splice.call(arguments, 1);return s.replace(/{(\d+)}/g, function (m, i) {return a[i];});};
HTMLCollection.prototype.click = function(f) {
	for(var i = this.length - 1; i >= 0; i--){
		this[i]. onclick = f;
	}
};

$ = function(c){
	return document.getElementsByClassName(c);
};
$.post = function(url, j, f){
	
	var a = new Array(j.length);
	for(k in j){
		a.push(String.format("{0}={1}", k, j[k]));
	}
	var xhr = new XMLHttpRequest();
	xhr.open('POST', url);
	xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xhr.send(a.join('&'));
	xhr.onload = function(){
		f(xhr.response);
	}
}
HTMLInputElement.prototype.val = function(v) {
	if(v == undefined){
		return this.value;
	}
	this.value = v;
};
HTMLElement.prototype.text = function(v) {
	if(v == undefined){
		return this.innerText;
	}
	this.innerText = v;
};
HTMLElement.prototype.html = function(v) {
	if(v == undefined){
		return this.innerHTML;
	}
	this.innerHTML = v;
};
HTMLElement.prototype.parent = function(v) {
	v = v.toUpperCase();
	var n = this.parentNode;
	while(n != null && n.tagName != v){
		n = n.parentNode;
	}
	return n;
};
HTMLElement.prototype.attr = function(k, v) {
	if(v == undefined){
		return this.getAttribute(k);
	}
	this.setAttribute(k, v);
};