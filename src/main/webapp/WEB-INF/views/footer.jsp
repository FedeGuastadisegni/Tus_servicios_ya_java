		<br>
		<br>
		<style>
.scrollup{
    width:40px;
    height:40px;
    opacity:0.3;
    position:fixed;
    bottom:50px;
    right:100px;
    display:none;
    text-indent:-9999px;
    background: url('./resources/img/icon_top.png') no-repeat;
}
</style>

<a href="#" class="scrollup">Scroll</a>
<div class="container">
		<footer>
			<p>&copy; 2014 - <b>Tus Servicios Ya</b>, Inc. &middot;</p>
		</footer>
	</div>
	<!-- script del scroll-up -->
	    <script type="text/javascript">
    $(document).ready(function(){
  
        $(window).scroll(function(){
            if ($(this).scrollTop() > 100) {
                $('.scrollup').fadeIn();
            } else {
                $('.scrollup').fadeOut();
            }
        });
  
        $('.scrollup').click(function(){
            $("html, body").animate({ scrollTop: 0 }, 600);
            return false;
        });
  
    });
    </script>
</body>
</html>
