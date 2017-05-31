<?
$database="CTUBUSDATABASE";
$host="localhost";
$username="root";
$password="";
$flag=0;
$name=$_POST['n'];
$email=$_POST['email'];
$phone=$_POST['p'];
$feedback=$_POST['f'];
//$name='testname';
//$email='testemail';
//$phone='testphone';
//$feedback='testfeedbacksdfsdfsdfsdftestfeedbacksdfsdfsdfsdf';
$conn=mysql_connect($host,$username,$password);
mysql_select_db($database,$conn);
if($query=mysql_query("insert into feedback(name,email,phone,feedback)values('$name','$email','$phone','$feedback')",$conn))

{
    $flag=1;
}
print(json_encode($flag));
mysql_close($conn);
?>