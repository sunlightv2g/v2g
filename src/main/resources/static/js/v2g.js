function userlogin(){
	if($('#loginid').val().trim() == ""){
		alert("아이디를 입력해주세요.");
		$('#loginid').val("");
		$('#loginid').focus();
		return false;
	}
	if($('#loginpass').val().trim() == ""){
		alert("비밀번호를 입력해주세요.");
		$('#loginpass').val("");
		$('#loginpass').focus();
		return false;
	}
	
    var data = {
    		userid: $('#loginid').val(),
    		userpass: $('#loginpass').val()
    	};

    $.ajax({
        type: 'POST',
        url: "/environment/userlogin",
        dataType: 'text',
        contentType:'application/json; charset=utf-8',
        data: JSON.stringify(data)
    }).done(function(data) {
    	if(data < 1){
    		alert("아이디 또는 비밀번호를 확인해주세요.");	
    	}else{
    		history.back("-1");
    	}
    	
        //alert('등록되었습니다.');
        
        //routinecheck.list();
    }).fail(function (error) {
        alert(error);
    });
}

function logout(){
	$.ajax({
		type: 'POST',
		url: "/environment/userlogout",
		dataType: 'text',
		contentType:'application/json; charset=utf-8',
	}).done(function(data) {
		//alert(data);
		location.reload();
	}).fail(function (error) {
		alert(error);
	});
	
}

function categoryChange(e) {
	  var var_a = ["구/읍/면","강남구","은평구", "도봉구", "강북구", "노원구", "성북구", "서대문구", "종로구", "동대문구", "중구", "성동구", "마포구", "중량구", "강서구", "광진구", "양천구", "구로구", "영등포구", "용산구", "강동구", "금천구", "관악구", "동작구", "서초구", "송파구"];
	  var var_b = ["구/읍/면"];
	  var target = document.getElementById("gumyun");
	 
	  if(e.value == "서울") var d = var_a;
	  else var d = var_b;

	  target.options.length = 0;
	 
	  for (x in d) {
	    var opt = document.createElement("option");
	    opt.value = d[x];
	    opt.innerHTML = d[x];
	    target.appendChild(opt);
	  } 
}

function seachSubmit(){
	var sido = $('#sido').val().trim();
	var gumyun = $('#gumyun').val().trim();
	var searchStr = $('#searchStr').val().trim();	
	
	if(sido == "서울" && gumyun == "구/읍/면" && searchStr == ""){
		location.href="/seoul";
	}else if(sido == "서울" && gumyun == "강남구" && searchStr == ""){
		location.href="/location";
	}else if(sido == "서울" && gumyun == "강남구" && searchStr == "도곡렉슬아파트"){
		location.href="/apt";
	}else{
		alert("검색된 데이터가 없습니다.");
	}
}