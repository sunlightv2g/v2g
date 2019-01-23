function categoryChangeReser(e) {
		  var var_a = ["구/읍/면","강남구","은평구", "도봉구", "강북구", "노원구", "성북구", "서대문구", "종로구", "동대문구", "중구", "성동구", "마포구", "중량구", "강서구", "광진구", "양천구", "구로구", "영등포구", "용산구", "강동구", "금천구", "관악구", "동작구", "서초구", "송파구"];
		  var var_b = ["구/읍/면"];
		  var target = document.getElementById("place2");
		 
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
	
	function doRegist(){
		
		if($('#userid').val().trim() == ""){
			alert("이용자ID를 입력해주세요.");
			$('#userid').val("");
			$('#userid').focus();
			return false;
		}
		if(($('#place1').val().trim() + $('#place2').val().trim() + $('#place3').val().trim()) == ""){
			alert("거래장소를 선택/입력해주세요.");
			$('#place1').focus();
			return false;
		}
		if($('#rtime1').val().trim() == ""){
			alert("거래시간을 선택해주세요.");
			$('#rtime1').val("");
			$('#rtime1').focus();
			return false;
		}
		if($('#rtime2').val().trim() == ""){
			alert("거래시간을 선택해주세요.");
			$('#rtime2').val("");
			$('#rtime2').focus();
			return false;
		}
		if($('#from1').val().trim() == ""){
			alert("거래일자를 선택해주세요.");
			$('#from1').val("");
			$('#from1').focus();
			return false;
		}
		if($('#relectirc').val().trim() == ""){
			alert("거래용량을 입력해주세요.");
			$('#relectirc').val("");
			$('#relectirc').focus();
			return false;
		}
		if($('#rleft').val().trim() == ""){
			alert("잔량을 입력해주세요.");
			$('#rleft').val("");
			$('#rleft').focus();
			return false;
		}
		if($('#rcost').val().trim() == ""){
			alert("거래금액을 입력해주세요.");
			$('#rcost').val("");
			$('#rcost').focus();
			return false;
		}
				
		var data = {
				userid: $('#userid').val().trim(),
				place: $('#place1').val().trim() + " " + $('#place2').val().trim() + " " + $('#place3').val().trim(),
				rdate: $('#from1').val(),
				rtime: $('#rtime1').val() + ":" + $('#rtime2').val(),
				rflag: $('#rflag').val(),
				rcost: $('#rcost').val(),
				relectirc: $('#relectirc').val(),
				rleft: $('#rleft').val(),
	    	};

	    $.ajax({
	        type: 'POST',
	        url: "/reservation",
	        dataType: 'text',
	        contentType:'application/json; charset=utf-8',
	        data: JSON.stringify(data)
	    }).done(function() {
	        alert('예약되었습니다.');
	        
	        $('#userid').val("");
	        $('#place1').val("");
	        $('#place2').val("");
	        $('#place3').val("");
	        $('#from1').val("");
	        $('#rtime1').val("");
	        $('#rtime2').val("");
	        $('#rflag').val("");
	        $('#rcost').val("");
	        $('#relectirc').val("");
	        $('#rleft').val("");
	        
	        //top.location.href=_uri;
	        //routinecheck.list();
	    }).fail(function (error) {
	        alert(error);
	    });
		
	}
	
	function doSearch() {
		
		if($('#suserid').val().trim() == ""){
			alert("이용자ID를 입력해주세요.");
			$('#suserid').val("");
			$('#suserid').focus();
			return false;
		}
		
		$.ajax({
	        type: 'GET',
	        url: "/reservation/"+$('#suserid').val().trim(),
	        dataType: 'json',
	        contentType:'application/json; charset=utf-8'
	    }).done(function(data) {
	    	
	    	if(data.length > 0){
		        $('#slpace').val(data[0].place);
		        $('#stime').val(data[0].rtime);
		        $('#sflag').val(data[0].rflag);
		        $('#sdate').val(data[0].rdate);
		        $('#selectric').val(data[0].relectirc);
		        $('#sleft').val(data[0].rleft);
		        $('#scost').val(data[0].rcost);
	    		
	    	}else{
	    		alert("검색된 데이터가 없습니다.");
	    		$('#slpace').val("");
		        $('#stime').val("");
	    		$('#sflag').val("");
		        $('#sdate').val("");
		        $('#selectric').val("");
		        $('#sleft').val("");
		        $('#scost').val("");
	    	}
	    	
	    }).fail(function (error) {
	        alert(error);
	    });
	}