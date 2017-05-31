<?
$username="root";
$password="";
$database="CTUBUSDATABASE";
$host="localhost";
$stopname=$_POST['stopname'];
$stoptime=$_POST['stoptime'];
$routeid=$_POST['routeid'];

$conn=mysql_connect($host,$username,$password) or die("CONNECTION NOT ESTABLISHED");
mysql_select_db($database,$conn) or die ("databse not selected");
mysql_query("insert into stopage_detail(stopname,stoptime,routeid)values('$stopname','$stoptime',$routeid)",$conn);
echo"ok";
?>