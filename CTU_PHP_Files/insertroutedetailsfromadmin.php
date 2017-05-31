<?php
$host="localhost";
$username="root";
$password="";
$database="CTUBUSDATABASE";
$a=$_POST['routename'];
$b=$_POST['start'];
$c=$_POST['stop'];
$d=$_POST['this'];
$e=$_POST['that'];
$flag=0;
$conn=mysql_connect($host,$username,$password) or die("connect ni hua");
mysql_select_db($database,$conn) or die("database ni hua select");
if(mysql_query("insert into route_master(routename,startname,endname,starttime,stoptime)values('$a','$b','$c','$d','$e')",$conn))
{
echo "success";
    $flag=1;
}
else
{
    echo"pblm hai boss";
}
print(json_encode($flag));
    mysql_close($conn);
?>
