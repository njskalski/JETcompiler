;Code generated by JETcompiler

declare i8*    @malloc(i32)
declare i8*    @calloc(i32, i32)
declare void   @free(i8*)
declare void   @printInt(i32)
declare void   @printDouble(double)
declare void   @printFloat(float)
declare void   @printString(i8*)
declare i32    @readInt()
declare double @readDouble()
declare float  @readFloat()

define i32 @main() {
;!!end function header
;!!begin IntegerLiteral:
%uid.1 = alloca i32
store i32 78, i32* %uid.1
;!!end IntegerLiteral:
;!!begin DeclarationStmt, FieldValue != null
%uid.0 = alloca i32
%uid.2 = load i32* %uid.1
store i32 %uid.2, i32* %uid.0
;!!end DeclarationStmt
;!!begin IntegerLiteral:
%uid.4 = alloca i32
store i32 1, i32* %uid.4
;!!end IntegerLiteral:
;!!begin DeclarationStmt, FieldValue != null
%uid.3 = alloca i32
%uid.5 = load i32* %uid.4
store i32 %uid.5, i32* %uid.3
;!!end DeclarationStmt
;!!begin FuncallOperatorExpr:
;!!begin and end of IdentifierExpr, passing "%uid.3" as "i"
%uid.6 = load i32* %uid.3
call void @printInt(i32 %uid.6)
;!!end FuncalOperatorExpr
;!!begin FuncallOperatorExpr:
;!!begin and end of IdentifierExpr, passing "%uid.0" as "i"
%uid.7 = load i32* %uid.0
call void @printInt(i32 %uid.7)
;!!end FuncalOperatorExpr
;!!begin WhileStmt:
br label %Label0LoopCond
Label0LoopCond:
;!!begin RelationExpr:
;!!begin and end of IdentifierExpr, passing "%uid.0" as "i"
%uid.8 = load i32* %uid.0
;!!begin IntegerLiteral:
%uid.10 = alloca i32
store i32 76, i32* %uid.10
;!!end IntegerLiteral:
%uid.9 = load i32* %uid.10
%uid.11 = icmp sgt i32 %uid.8, %uid.9
%uid.12 = alloca i1
store i1 %uid.11, i1* %uid.12
;!!end RelationExpr
%uid.13 = load i1* %uid.12
br i1 %uid.13, label %Label1LoopBody, label %Label2LoopEnd
Label1LoopBody:
;!!begin SuffixIncDecExpr:
%uid.15 = alloca i32%uid.14 = load i32* %uid.0
%uid.16 = sub i32 %uid.14, 1
store i32 %uid.16, i32* %uid.0
store i32 %uid.14, i32* %uid.15
;!!end SuffixIncDecExpr
;!!begin FuncallOperatorExpr:
;!!begin and end of IdentifierExpr, passing "%uid.0" as "i"
%uid.17 = load i32* %uid.0
call void @printInt(i32 %uid.17)
;!!end FuncalOperatorExpr
;!!begin AddExpr:
;!!begin and end of IdentifierExpr, passing "%uid.0" as "i"
%uid.19 = load i32* %uid.0
;!!begin IntegerLiteral:
%uid.21 = alloca i32
store i32 7, i32* %uid.21
;!!end IntegerLiteral:
%uid.20 = load i32* %uid.21
%uid.22 = add i32 %uid.19, %uid.20
%uid.23 = alloca i32
store i32 %uid.22, i32* %uid.23
;!!end AddExpr:
;!!begin DeclarationStmt, FieldValue != null
%uid.18 = alloca i32
%uid.24 = load i32* %uid.23
store i32 %uid.24, i32* %uid.18
;!!end DeclarationStmt
;!!begin FuncallOperatorExpr:
;!!begin and end of IdentifierExpr, passing "%uid.18" as "i"
%uid.25 = load i32* %uid.18
call void @printInt(i32 %uid.25)
;!!end FuncalOperatorExpr
br label%Label0LoopCond
Label2LoopEnd:
;!!end WhileStmt
;!!begin FuncallOperatorExpr:
;!!begin and end of IdentifierExpr, passing "%uid.0" as "i"
%uid.26 = load i32* %uid.0
call void @printInt(i32 %uid.26)
;!!end FuncalOperatorExpr
;!! IfteStmt
;!!begin RelationExpr:
;!!begin and end of IdentifierExpr, passing "%uid.0" as "i"
%uid.27 = load i32* %uid.0
;!!begin IntegerLiteral:
%uid.29 = alloca i32
store i32 4, i32* %uid.29
;!!end IntegerLiteral:
%uid.28 = load i32* %uid.29
%uid.30 = icmp sgt i32 %uid.27, %uid.28
%uid.31 = alloca i1
store i1 %uid.30, i1* %uid.31
;!!end RelationExpr
%uid.32 = load i1* %uid.31
br i1 %uid.32, label %Label3IfteTrue, label %Label4IfteFalse
Label3IfteTrue:
;!!begin IntegerLiteral:
%uid.34 = alloca i32
store i32 4, i32* %uid.34
;!!end IntegerLiteral:
;!!begin DeclarationStmt, FieldValue != null
%uid.33 = alloca i32
%uid.35 = load i32* %uid.34
store i32 %uid.35, i32* %uid.33
;!!end DeclarationStmt
;!!begin FuncallOperatorExpr:
;!!begin and end of IdentifierExpr, passing "%uid.33" as "i"
%uid.36 = load i32* %uid.33
call void @printInt(i32 %uid.36)
;!!end FuncalOperatorExpr
br label %Label5IfteEnd
Label4IfteFalse:
;!!begin FuncallOperatorExpr:
;!!begin StringLiteral:
;!!begin Malloc.GenerateStringAllocation():
%uid.38 = call i8* @malloc (i32 4)
;!!end Malloc.GenerateStringAllocation():
%uid.39 = bitcast i8* %uid.38 to [4 x i8]*
store [4 x i8] c"foo\00", [4 x i8]* %uid.39
%uid.40 = alloca i8*
store i8* %uid.38, i8** %uid.40
;!!end StringLiteral
%uid.37 = load i8** %uid.40
call void @printString(i8* %uid.37)
;!!end FuncalOperatorExpr
br label %Label5IfteEnd
Label5IfteEnd:
;!!end ifte
;!!begin FuncallOperatorExpr:
;!!begin and end of IdentifierExpr, passing "%uid.0" as "i"
%uid.41 = load i32* %uid.0
call void @printInt(i32 %uid.41)
;!!end FuncalOperatorExpr
;!!ReturnStmt:
;!!begin IntegerLiteral:
%uid.42 = alloca i32
store i32 0, i32* %uid.42
;!!end IntegerLiteral:
%uid.43 = load i32* %uid.42
ret i32 %uid.43
}
