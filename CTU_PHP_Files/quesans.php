<?php
$host="localhost";
$username="root";
$password="";
$database="CTUBUSDATABASE";
$user=$_POST['cname'];
//$user="Fot";
$conn=mysql_connect($host,$username,$password)or die ("not server");
mysql_select_db($database,$conn)or die ("not selected");
$query=mysql_query("select securityquestion,canswer from UserDetails where cname='$user'",$conn) or die ("incorrect details");
while($row=mysql_fetch_array($query))
{
	$flag['securityquestion']=$row['securityquestion'];
    $flag['canswer']=$row['canswer'];
}

print(json_encode($flag));
mysql_close($conn);
?>