/**
 * 
 */
function updateCheck(){
	const frm 	   = document.frm;
	const title	   =frm.title;
	const price	   =frm.price;
	const director = frm.director;
	const actor    = frm.actor;
	const synopsis = frm.synopsis;
	
	if(title.value.length===0){
		alert(`영화제목을 확인해주세요`);
		title.focus();
		return false;
	}
	
	if(price.value.length===0){
		alert(`영화가격을 확인해주세요`);
		price.focus();
		return false;
	}
	
	if(director.value.length===0){
		alert(`감독 란을 확인해주세요`);
		director.focus();
		return false;
	}
	
	if(actor.value.length===0){
		alert(`배우 란을 확인해주세요`);
		actor.focus();
		return false;
	}
	
	if(synopsis.value.length===0){
		alert(`설명(시놉시스)란을 확인해주세요`);
		synopsis.focus();
		return false;
	}
	
	return true;
}