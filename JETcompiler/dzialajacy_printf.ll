@str = internal constant [13 x i8] c"hello world\0A\00"
 
define void @main() nounwind
{
	call i32 (i8*, ...)* @printf(i8* getelementptr([13 x i8]* @str, i32 0, i8 0))
	ret void;
}
 
declare i32 @printf(i8*, ...) nounwind

