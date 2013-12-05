<#include "./header.ftl"> 

<body><div class="background">
 			
            
     <!--adding some style to tables -->
     <style>
#unilinks
{
font-family:"Trebuchet MS", Arial, Helvetica, sans-serif;
width:100%;
border-collapse:collapse;
}
#unilinks td, #unilinks th 
{
font-size:1em;
border:1px solid #98bf21;
padding:3px 7px 2px 7px;
}
#unilinks th 
{
font-size:1.1em;
text-align:left;
padding-top:5px;
padding-bottom:4px;
background-color:#0066CC;
color:#ffffff;
}
#unilinks tr.alt td 
{
color:#000000;
background-color:#66CCFF;
}
     </style>       
         <!--added CSS-->
            <link rel="stylesheet" href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css" media="screen">
            <link href="//bootswatch.com/cerulean/bootstrap.min.css" rel="stylesheet">
              
            
            
<#if container??>
  <div ="${container}">
   
<#else>
  <div ="default">
</#if>
<form>
<br/>
<#if careerDetails?has_content>
<h1><div align="center">Details of University</div></h1>
<div ="input page">
<div class="table-responsive" align="center">

<table id="unilinks" class="table" border="1" cellpadding="5">
 <#list universityObject as universityObject>
     <tr>
     <th>School Name</th>
     <th>Contact Info</th>
     <th>Location</th>
     <th>Tuition Fees</th>
     <tr>
     <td>${universityObject.getSchoolName()}</td>
     <td>${universityObject.getContactInfo()}</td>   
     <td>${universityObject.getLocation()}</td>   
     <td>${universityObject.getTutionFees()}</td>       
    </tr>    
  </#list> 
  </table>
  </div>
  <!--Department table-->
  <div class="table-responsive" align="center">
  <table id="unilinks" class="table" border="1" cellpadding="5">
  <tr>
     <th>Department Name</th>
     <th>Toefl Score</th>
     <th>GRE score</th>
     <th>IELTS score</th>
     <tr>
 <#list departmentObject as departmentObject>
     
     <td>${departmentObject.getDepartmentName()}</td>
     <td>${departmentObject.getToeflscore()}</td>   
     <td>${departmentObject.getGrescore()}</td>   
     <td>${departmentObject.getIeltscore()}</td>       
    </tr>    
  </#list> 
  </table>
  </div>

    <div align="center">
  <img src="http://oi41.tinypic.com/2r4rcba.jpg"/>
  </div>
    <h3 align="center">University Salary Average</h3>
    <div align="center">
  <div id="chart_div" style="width: 900px; height: 500px;"></div> 
  </div>
    <div align="center">
  <img src="http://oi41.tinypic.com/2r4rcba.jpg"/>
  </div>
  <h3 align="center">Placement Information from LinkedIn</h3>
  <div class="table-responsive" align="center">
  <table id="unilinks" class="table" border="1" cellpadding="5">
     <tr>
     <th>FirstName</th>
     <th>LastName</th>
     <th>Headline</th>
     <th>ProfileURL</th>
     <tr>
     <#list careerDetails as careerDetails>
     <td>${careerDetails.getFirstName()}</td>
     <td>${careerDetails.getLastName()}</td>
     <td>${careerDetails.getHeadline()}</td>
     <td>${careerDetails.getProfileURL()}</td>         
    </tr>    
  </#list>  
  </div> 
   
 
    </table>
   
 
  <table class="datatable" border="1" cellpadding="5" style="display:none">
  <#list salaryDetails as salaryDetails>
  <tr>
  <td id="one">${salaryDetails.getA()}</td>
  <td id="two">${salaryDetails.getB()}</td>
  <td id="three">${salaryDetails.getC()}</td>
  <td id="four">${salaryDetails.getD()}</td>
  <td id="five">${salaryDetails.getE()}</td>
  <td id="six">${salaryDetails.getF()}</td>
  <td id="seven">${salaryDetails.getG()}</td>
  <td id="eight">${salaryDetails.getH()}</td>
  <td id="nine">${salaryDetails.getI()}</td>
  <td id="ten">${salaryDetails.getJ()}</td>
  </tr>
  </#list>
  </table> 
  <br/>
  <br/>
  <div>
  <img src="http://oi41.tinypic.com/2r4rcba.jpg"/>
  </div>
  <h3 align="center">Want these College Details? Enter your Email ID</h3>
  <input type="text" name="sendEmailZ" /> <br/><br/>
  <input type="submit" value="SendDetails" name="details" />
  
</div>
<#else>



<div align="left">
</marquee>
<marquee  bgcolor="#3333FF" behavior="scroll" direction="left" scroll="continuous" onmouseover="this.stop();" onmouseout="this.start();">
<img src="http://i39.tinypic.com/o7r71d.jpg"/>
<img src="http://i40.tinypic.com/dfiiw.jpg"/>
<img src="http://i43.tinypic.com/i5cfuw.jpg"/>
<img src="http://i44.tinypic.com/1znv91z.jpg"/>
<img src="http://i39.tinypic.com/1kn7r.jpg"/>
<img src="http://i42.tinypic.com/29wn3b6.jpg"/>
<img src="http://i43.tinypic.com/w7bngm.jpg"/>
<img src="http://i43.tinypic.com/wa4vmu.jpg"/>
<img src="http://i39.tinypic.com/ojl5e0.jpg"/>
<img src="http://i44.tinypic.com/n3b70p.jpg"/>
<img src="http://i41.tinypic.com/vsp45d.jpg"/>
<img src="http://i40.tinypic.com/b3kjuo.jpg"/>
<img src="http://i39.tinypic.com/2isbi9c.jpg"/>
<img src="http://i41.tinypic.com/2zqh6yt.jpg"/>
<img src="http://i39.tinypic.com/2vtabsw.jpg"/>
<img src="http://i41.tinypic.com/10fbytf.jpg"/>
<img src="http://i39.tinypic.com/2a6s5c6.jpg"/>
<img src="http://i41.tinypic.com/3359x10.jpg"/>
<img src="http://i40.tinypic.com/10ftmk7.jpg"/>
<img src="http://i40.tinypic.com/149weag.jpg"/>
<img src="http://i43.tinypic.com/2wnxunm.jpg"/>
<img src="http://i39.tinypic.com/2zjcs4w.jpg"/>
<img src="http://i41.tinypic.com/2cs7y86.jpg"/>
<img src="http://i42.tinypic.com/5kfrm8.jpg"/>
</marquee>
</div>
<hr color="black" size="1000">
<div align="center"><img src="http://i41.tinypic.com/v5dao7.png"/></div></h1></font></div>
<h3><div align ="center">Your One Stop Destination for University Search</div></h3>
<h3><div align ="center">Enter the name of the university you are looking for</div></h3>
<div align="center"><input type="text" name="searchText" /> <br/><br/>
<input type="submit" value="Search" name="submit" />
<br/>
<br/>
</div>
</#if>

<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script>
var v1= parseInt(document.getElementById("one").textContent);
var v2= parseInt(document.getElementById("two").textContent);
var v3= parseInt(document.getElementById("three").textContent);
var v4= parseInt(document.getElementById("four").textContent);
var v5= parseInt(document.getElementById("five").textContent);
var v6= parseInt(document.getElementById("six").textContent);
var v7= parseInt(document.getElementById("seven").textContent);
var v8= parseInt(document.getElementById("eight").textContent);
var v9= parseInt(document.getElementById("nine").textContent);
var vten= parseInt(document.getElementById("ten").textContent);


 
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Department', '2011-12', '2010-11'],
          ['Computer Engineering',  v1,      v2],
          ['Software Engineering',  v3,      v4],
          ['Mechanical and Aerospace Engineering',  v5,       v6],
          ['Chemical and Materials Engineering',  v7,      v8],
          ['Civil Engineering',  v9,   vten]
        ]);

        var options = {
          
          vAxis: {title: 'Graduate Department',  titleTextStyle: {color: 'red'}}
        };

        var chart = new google.visualization.BarChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
      
</script>


</form>
</div>
</body>
<#include "./footer.ftl"> 