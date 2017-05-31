<?php
$host="localhost";
$username="root";
$password="";
$database="CTUBUSDATABASE";
$u=$_POST['username'];
$p=$_POST['password'];
$type=$_POST['submit'];
$conn=mysql_connect($host,$username,$password)or die ("not server");
$flag['code']=0;
mysql_select_db($database,$conn)or die ("not selected");
if($type=="up")
{
if($r=mysql_query("update Admin set password= '$p' WHERE uname='$u'",$conn))
{
    $flag['code']=1;   
}
}
if($type=="delete")
{
mysql_query("delete from Admin where uname='$u'",$conn);
    
}
print(json_encode($flag));
    mysql_close($conn);
?>