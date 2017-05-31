<?php
$host="localhost";
$username="root";
$password="";
$database="CTUBUSDATABASE";
$busno=$_POST['busno'];
$routeid=$_POST['routeid'];
$conn=mysql_connect($host,$username,$password);
mysql_select_db($database,$conn);
mysql_query("insert into allotbus (busno,routeid)values('$busno',$routeid)",$conn);

echo "success";
mysql_close($conn);
?>