var last_id=null;
	function toggle(id)
	{
		var e=document.getElementById(id);
		e.style.display=e.style.display=='' ? 'none' : '';
		if(last_id==null){
			last_id=document.getElementById('admin_login');
		}
		if(last_id!=e)			
			last_id.style.display='none';
		last_id=e;
	}
	
	(function($)
			{
				hideMessage = function() 
				{
					$("#admin_msg").fadeOut(4000);
					$("#user_msg").fadeOut(4000);
					$("#process_msg").fadeOut(4000);
				};
			}
		)(jQuery);	
	function startTimer() 
	{
		var tim = window.setTimeout("hideMessage()", 2000);  // 5000 milliseconds = 5 seconds
	}	