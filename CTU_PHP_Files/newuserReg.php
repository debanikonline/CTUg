<?php
$host="localhost";
$username="root";
$password="";
$database="CTUBUSDATABASE";
$row=0;

$flag['code']=0;
//$name=$_POST['cname'];
//$email=$_POST['cmail'];
//$phone=$_POST['cphone'];
//$answer=$_POST['canswer'];
//$password=$_POST['cpassword'];
$conn=mysql_connect($host,$username,$password)or die("connection error");
mysql_select_db($database,$conn) or die("Database not selected");
//$query=mysql_query("insert into UserDetails(cname,cmail,cphone,canswer,cpassword)values('$name','$cmail',$phone,'$answer','$password')");
if($query=mysql_query("insert into UserDetails(cname,cmail,cphone,canswer,cpassword)values('debanik3','debanikonlie@gmail.com',8194946794,'babi','Fingerprint')",$conn))
{
    $flag['code']=1;
}
    print json_encode($flag);

?>