<?php
$username="root";
$password="";
$database="CTUBUSDATABASE";
$host="localhost";
$uname=$_POST['zname'];
$umail=$_POST['zmail'];
$uphone=$_POST['zphone'];
$uanswer=$_POST['zanswer'];
$upassword=$_POST['zpassword'];
$uques=$_POST['zques'];
$conn=mysql_connect($host,$username,$password) or die("CONNECTION NOT ESTABLISHED");
mysql_select_db($database,$conn) or die ("databse not selected");

mysql_query("insert into UserDetails (cname,cmail,cphone,canswer,cpassword,securityquestion)values('$uname','$umail',$uphone,'$uanswer','$upassword','$uques')",$conn) or die ("insertion not completed");
echo "success";
mysql_close($conn);

?>