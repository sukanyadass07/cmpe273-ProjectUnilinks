<#include "./header.ftl"> 
<style>
div.background
{

  background: url("http://4.bp.blogspot.com/_-mY2ck9YCeE/TQOy3i3SZBI/AAAAAAAABJA/kgzqiAOylC8/s1600/snow_crystal_christmas.jpg") repeat;
  border: 2px solid black;
}
div.transbox
{

  margin: 30px 50px;
  background-color: #ffffff;
  border: 1px solid black;
  opacity:0.6;
  filter:alpha(opacity=60); /* For IE8 and earlier */
}
div.transbox p
{
  margin: 30px 40px;
  font-weight: bold;
  color: #000000;
}
</style>
<body><div class="background">
 <!-- Latest compiled and minified CSS -->
            <link rel="stylesheet" href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css" media="screen">
            <link href="//bootswatch.com/cerulean/bootstrap.min.css" rel="stylesheet">
           
           <!--script for slideshow-->
           
			<script>
 var image1=new Image()
image1.src="http://collegefootballzealots.com/images/stories/SJSU%20Logo.gif";
var image2=new Image()
image2.src="http://www.public.asu.edu/~pturaga/images/asu-logo.jpg";
var image3=new Image()
image3.src="http://www.harvard.edu/sites/default/files/user13/harvard_shield_wreath.png";
      var step=1
function slideit(){
//if browser does not support the image object, exit.
if (!document.images)
return
document.images.slide.src=eval("image"+step+".src")
if (step<3)
step++
else
step=1
//call function "slideit()" every 2.5 seconds
setTimeout("slideit()",5000)
}
slideit()
			</script>




          
          
            
<#if container??>
  <div ="${container}">
<#else>
  <div ="default">
</#if>
<form>
<br/>
<#assign count=0>
<#if careerDetails?has_content>
  
<h1><div align="center">Details of University</div></h1>
<div ="input page">
<div class="table-responsive" align="center">
 <table class="table" border="2" cellpadding="5">

 <#list careerDetails as careerDetails>
     <tr class="success">
     <td id= "one">${careerDetails.getCount()}</td>
     <td>${careerDetails.getSchoolName()}</td>
     <td>${careerDetails.getOrgName()}</td>   
  	 <#assign count = count + 1>
    </tr>
  </#list>  
    </table>
    


</div>
<#else>


<!-- changing image -->


<div ="images" align="right">
<img id="img" name="slide" src="https://www.realmagnet.com/wp-content/uploads/2011/10/San-Jose-State-University.png" height="37" width="236" border="0px"/></div>
</div>

<!--including frames-->
<iframe id="frame" name="slide" src="http://www.dynamicdrive.com/forums/showthread.php?49465-HTML-Code-for-Slideshow" align="left"></iframe>



<h1><div align ="center"><font size=14>

<!--nav bar

  <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
</nav>

-->


<img src="http://i41.tinypic.com/v5dao7.png"/></div></h1></font>
<h2><div align ="center">Your one stop destination for university search</div></h2>
<h3><div align ="center">Enter the name or part of the name of the university you are looking for</div></h3>
<div align="center"><input type="text" name="searchText" /> <br/><br/>
<input type="submit" value="submit" name="submit" /></div>
</#if>
<div id='table_div'></div>
<div id='piechart_3d'></div>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script>
var a= document.getElementById("one").textContent;
var b= 5; 
 google.load("visualization", "1", {packages:['table','corechart']});
      google.setOnLoadCallback(draw);
      function draw() {
        var data = google.visualization.arrayToDataTable([
          ['san', 10],
          ['Work',  2],
          [a,    3],
          ['Commute', 4],
          ['Watch TV', b],
          ['Sleep',    6]
        ]);
         var options = {
          title: 'SJSU Career Prospect',
          is3D: true,
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
        chart.draw(data, options);
        //table
          var jsonData = $.ajax({
          url: "getData.php",
          dataType:"json",
          async: false
          }).responseText;
          alert("after json data"+jsonData);
     var tableData = new google.visualization.DataTable(jsonData);

        var table = new google.visualization.Table(document.getElementById('table_div'));
        table.draw(tableData, {showRowNumber: true});
      }
      


   
 </script>

</form>
</div>
</body>
<#include "./footer.ftl"> 