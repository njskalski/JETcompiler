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
;!!begin FuncallOperatorExpr:
;!!begin FuncallOperatorExpr:
;!!begin IntegerLiteral:
%uid.2 = alloca i32
store i32 10, i32* %uid.2
;!!end IntegerLiteral:
%uid.1 = load i32* %uid.2
%uid.3 = call i32 @fac(i32 %uid.1)
;!!end FuncalOperatorExpr
%uid.4 = alloca i32
store i32 %uid.3, i32* %uid.4
%uid.0 = load i32* %uid.4
call void @printInt(i32 %uid.0)
;!!end FuncalOperatorExpr
;!!begin FuncallOperatorExpr:
;!!begin FuncallOperatorExpr:
;!!begin IntegerLiteral:
%uid.7 = alloca i32
store i32 10, i32* %uid.7
;!!end IntegerLiteral:
%uid.6 = load i32* %uid.7
%uid.8 = call i32 @rfac(i32 %uid.6)
;!!end FuncalOperatorExpr
%uid.9 = alloca i32
store i32 %uid.8, i32* %uid.9
%uid.5 = load i32* %uid.9
call void @printInt(i32 %uid.5)
;!!end FuncalOperatorExpr
;!!begin FuncallOperatorExpr:
;!!begin FuncallOperatorExpr:
;!!begin IntegerLiteral:
%uid.12 = alloca i32
store i32 10, i32* %uid.12
;!!end IntegerLiteral:
%uid.11 = load i32* %uid.12
%uid.13 = call i32 @mfac(i32 %uid.11)
;!!end FuncalOperatorExpr
%uid.14 = alloca i32
store i32 %uid.13, i32* %uid.14
%uid.10 = load i32* %uid.14
call void @printInt(i32 %uid.10)
;!!end FuncalOperatorExpr
;!!begin FuncallOperatorExpr:
;!!begin FuncallOperatorExpr:
;!!begin IntegerLiteral:
%uid.17 = alloca i32
store i32 10, i32* %uid.17
;!!end IntegerLiteral:
%uid.16 = load i32* %uid.17
%uid.18 = call i32 @ifac(i32 %uid.16)
;!!end FuncalOperatorExpr
%uid.19 = alloca i32
store i32 %uid.18, i32* %uid.19
%uid.15 = load i32* %uid.19
call void @printInt(i32 %uid.15)
;!!end FuncalOperatorExpr
;!!begin DeclarationStmt, FieldValue == null
%uid.20 = alloca double
;!!end DeclarationStmt
;!!begin IntegerLiteral:
%uid.22 = alloca i32
store i32 10, i32* %uid.22
;!!end IntegerLiteral:
;!!begin DeclarationStmt, FieldValue != null
%uid.21 = alloca i32
%uid.23 = load i32* %uid.22
store i32 %uid.23, i32* %uid.21
;!!end DeclarationStmt
;!!begin IntegerLiteral:
%uid.25 = alloca i32
store i32 1, i32* %uid.25
;!!end IntegerLiteral:
;!!begin DeclarationStmt, FieldValue != null
%uid.24 = alloca i32
%uid.26 = load i32* %uid.25
store i32 %uid.26, i32* %uid.24
;!!end DeclarationStmt
;!!begin WhileStmt:
br label %Label0LoopCond
Label0LoopCond:
;!!begin RelationExpr:
;!!begin and end of IdentifierExpr, passing "%uid.21" as "n"
%uid.27 = load i32* %uid.21
;!!begin IntegerLiteral:
%uid.29 = alloca i32
store i32 0, i32* %uid.29
;!!end IntegerLiteral:
%uid.28 = load i32* %uid.29
%uid.30 = icmp sgt i32 %uid.27, %uid.28
%uid.31 = alloca i1
store i1 %uid.30, i1* %uid.31
;!!end RelationExpr
%uid.32 = load i1* %uid.31
br i1 %uid.32, label %Label1LoopBody, label %Label2LoopEnd
Label1LoopBody:
;!!begin AssignmentExpr:
;!!begin MultExpr:
;!!begin and end of IdentifierExpr, passing "%uid.24" as "r"
%uid.33 = load i32* %uid.24
;!!begin and end of IdentifierExpr, passing "%uid.21" as "n"
%uid.34 = load i32* %uid.21
%uid.35 = mul i32 %uid.33, %uid.34
%uid.36 = alloca i32
store i32 %uid.35, i32* %uid.36
;!!end MultExpr
;!!begin and end of IdentifierExpr, passing "%uid.24" as "r"
%uid.37 = load i32* %uid.36
store i32 %uid.37, i32* %uid.24
;!!end AssignmentExpr:
;!!begin AssignmentExpr:
;!!begin AddExpr:
;!!begin and end of IdentifierExpr, passing "%uid.21" as "n"
%uid.38 = load i32* %uid.21
;!!begin IntegerLiteral:
%uid.40 = alloca i32
store i32 1, i32* %uid.40
;!!end IntegerLiteral:
%uid.39 = load i32* %uid.40
%uid.41 = sub i32 %uid.38, %uid.39
%uid.42 = alloca i32
store i32 %uid.41, i32* %uid.42
;!!end AddExpr:
;!!begin and end of IdentifierExpr, passing "%uid.21" as "n"
%uid.43 = load i32* %uid.42
store i32 %uid.43, i32* %uid.21
;!!end AssignmentExpr:
br label%Label0LoopCond
Label2LoopEnd:
;!!end WhileStmt
;!!begin FuncallOperatorExpr:
;!!begin and end of IdentifierExpr, passing "%uid.24" as "r"
%uid.44 = load i32* %uid.24
call void @printInt(i32 %uid.44)
;!!end FuncalOperatorExpr
;!!begin FuncallOperatorExpr:
;!!begin FuncallOperatorExpr:
;!!begin DoubleLiteral:
%uid.47 = alloca double
store double 10.0, double* %uid.47
;!!end DoubleLiteral:
%uid.46 = load double* %uid.47
%uid.48 = call double @dfac(double %uid.46)
;!!end FuncalOperatorExpr
%uid.49 = alloca double
store double %uid.48, double* %uid.49
%uid.45 = load double* %uid.49
call void @printDouble(double %uid.45)
;!!end FuncalOperatorExpr
;!!begin FuncallOperatorExpr:
;!!begin StringLiteral:
;!!begin Malloc.GenerateStringAllocation():
%uid.51 = call i8* @malloc (i32 9)
;!!end Malloc.GenerateStringAllocation():
%uid.52 = bitcast i8* %uid.51 to [9 x i8]*
store [9 x i8] c"hello */\00", [9 x i8]* %uid.52
%uid.53 = alloca i8*
store i8* %uid.51, i8** %uid.53
;!!end StringLiteral
%uid.50 = load i8** %uid.53
call void @printString(i8* %uid.50)
;!!end FuncalOperatorExpr
;!!begin FuncallOperatorExpr:
;!!begin StringLiteral:
;!!begin Malloc.GenerateStringAllocation():
%uid.55 = call i8* @malloc (i32 9)
;!!end Malloc.GenerateStringAllocation():
%uid.56 = bitcast i8* %uid.55 to [9 x i8]*
store [9 x i8] c"/* world\00", [9 x i8]* %uid.56
%uid.57 = alloca i8*
store i8* %uid.55, i8** %uid.57
;!!end StringLiteral
%uid.54 = load i8** %uid.57
call void @printString(i8* %uid.54)
;!!end FuncalOperatorExpr
;!!ReturnStmt:
;!!begin IntegerLiteral:
%uid.58 = alloca i32
store i32 0, i32* %uid.58
;!!end IntegerLiteral:
%uid.59 = load i32* %uid.58
ret i32 %uid.59
}
define i32 @fac(i32 %uid.60) {
%uid.61 = alloca i32
store i32 %uid.60, i32* %uid.61
;!!end function header
;!!begin DeclarationStmt, FieldValue == null
%uid.62 = alloca i32
;!!end DeclarationStmt
;!!begin DeclarationStmt, FieldValue == null
%uid.63 = alloca i32
;!!end DeclarationStmt
;!!begin AssignmentExpr:
;!!begin IntegerLiteral:
%uid.64 = alloca i32
store i32 1, i32* %uid.64
;!!end IntegerLiteral:
;!!begin and end of IdentifierExpr, passing "%uid.62" as "r"
%uid.65 = load i32* %uid.64
store i32 %uid.65, i32* %uid.62
;!!end AssignmentExpr:
;!!begin AssignmentExpr:
;!!begin and end of IdentifierExpr, passing "%uid.61" as "a"
;!!begin and end of IdentifierExpr, passing "%uid.63" as "n"
%uid.66 = load i32* %uid.61
store i32 %uid.66, i32* %uid.63
;!!end AssignmentExpr:
;!!begin WhileStmt:
br label %Label3LoopCond
Label3LoopCond:
;!!begin RelationExpr:
;!!begin and end of IdentifierExpr, passing "%uid.63" as "n"
%uid.67 = load i32* %uid.63
;!!begin IntegerLiteral:
%uid.69 = alloca i32
store i32 0, i32* %uid.69
;!!end IntegerLiteral:
%uid.68 = load i32* %uid.69
%uid.70 = icmp sgt i32 %uid.67, %uid.68
%uid.71 = alloca i1
store i1 %uid.70, i1* %uid.71
;!!end RelationExpr
%uid.72 = load i1* %uid.71
br i1 %uid.72, label %Label4LoopBody, label %Label5LoopEnd
Label4LoopBody:
;!!begin AssignmentExpr:
;!!begin MultExpr:
;!!begin and end of IdentifierExpr, passing "%uid.62" as "r"
%uid.73 = load i32* %uid.62
;!!begin and end of IdentifierExpr, passing "%uid.63" as "n"
%uid.74 = load i32* %uid.63
%uid.75 = mul i32 %uid.73, %uid.74
%uid.76 = alloca i32
store i32 %uid.75, i32* %uid.76
;!!end MultExpr
;!!begin and end of IdentifierExpr, passing "%uid.62" as "r"
%uid.77 = load i32* %uid.76
store i32 %uid.77, i32* %uid.62
;!!end AssignmentExpr:
;!!begin AssignmentExpr:
;!!begin AddExpr:
;!!begin and end of IdentifierExpr, passing "%uid.63" as "n"
%uid.78 = load i32* %uid.63
;!!begin IntegerLiteral:
%uid.80 = alloca i32
store i32 1, i32* %uid.80
;!!end IntegerLiteral:
%uid.79 = load i32* %uid.80
%uid.81 = sub i32 %uid.78, %uid.79
%uid.82 = alloca i32
store i32 %uid.81, i32* %uid.82
;!!end AddExpr:
;!!begin and end of IdentifierExpr, passing "%uid.63" as "n"
%uid.83 = load i32* %uid.82
store i32 %uid.83, i32* %uid.63
;!!end AssignmentExpr:
br label%Label3LoopCond
Label5LoopEnd:
;!!end WhileStmt
;!!ReturnStmt:
;!!begin and end of IdentifierExpr, passing "%uid.62" as "r"
%uid.84 = load i32* %uid.62
ret i32 %uid.84
}
define i32 @rfac(i32 %uid.85) {
%uid.86 = alloca i32
store i32 %uid.85, i32* %uid.86
;!!end function header
;!! IfteStmt
;!!begin EqualExpr:
;!!begin and end of IdentifierExpr, passing "%uid.86" as "n"
%uid.87 = load i32* %uid.86
;!!begin IntegerLiteral:
%uid.89 = alloca i32
store i32 0, i32* %uid.89
;!!end IntegerLiteral:
%uid.88 = load i32* %uid.89
%uid.90 = icmp eq i32 %uid.87, %uid.88
%uid.91 = alloca i1
store i1 %uid.90, i1* %uid.91
;!!end EqualExpr:
%uid.92 = load i1* %uid.91
br i1 %uid.92, label %Label6IfteTrue, label %Label7IfteFalse
Label6IfteTrue:
;!!ReturnStmt:
;!!begin IntegerLiteral:
%uid.93 = alloca i32
store i32 1, i32* %uid.93
;!!end IntegerLiteral:
%uid.94 = load i32* %uid.93
ret i32 %uid.94
br label %Label8IfteEnd
Label7IfteFalse:
;!!ReturnStmt:
;!!begin MultExpr:
;!!begin and end of IdentifierExpr, passing "%uid.86" as "n"
%uid.95 = load i32* %uid.86
;!!begin FuncallOperatorExpr:
;!!begin AddExpr:
;!!begin and end of IdentifierExpr, passing "%uid.86" as "n"
%uid.98 = load i32* %uid.86
;!!begin IntegerLiteral:
%uid.100 = alloca i32
store i32 1, i32* %uid.100
;!!end IntegerLiteral:
%uid.99 = load i32* %uid.100
%uid.101 = sub i32 %uid.98, %uid.99
%uid.102 = alloca i32
store i32 %uid.101, i32* %uid.102
;!!end AddExpr:
%uid.97 = load i32* %uid.102
%uid.103 = call i32 @rfac(i32 %uid.97)
;!!end FuncalOperatorExpr
%uid.104 = alloca i32
store i32 %uid.103, i32* %uid.104
%uid.96 = load i32* %uid.104
%uid.105 = mul i32 %uid.95, %uid.96
%uid.106 = alloca i32
store i32 %uid.105, i32* %uid.106
;!!end MultExpr
%uid.107 = load i32* %uid.106
ret i32 %uid.107
br label %Label8IfteEnd
Label8IfteEnd:
;!!end ifte
}
define i32 @mfac(i32 %uid.108) {
%uid.109 = alloca i32
store i32 %uid.108, i32* %uid.109
;!!end function header
;!! IfteStmt
;!!begin EqualExpr:
;!!begin and end of IdentifierExpr, passing "%uid.109" as "n"
%uid.110 = load i32* %uid.109
;!!begin IntegerLiteral:
%uid.112 = alloca i32
store i32 0, i32* %uid.112
;!!end IntegerLiteral:
%uid.111 = load i32* %uid.112
%uid.113 = icmp eq i32 %uid.110, %uid.111
%uid.114 = alloca i1
store i1 %uid.113, i1* %uid.114
;!!end EqualExpr:
%uid.115 = load i1* %uid.114
br i1 %uid.115, label %Label9IfteTrue, label %Label10IfteFalse
Label9IfteTrue:
;!!ReturnStmt:
;!!begin IntegerLiteral:
%uid.116 = alloca i32
store i32 1, i32* %uid.116
;!!end IntegerLiteral:
%uid.117 = load i32* %uid.116
ret i32 %uid.117
br label %Label11IfteEnd
Label10IfteFalse:
;!!ReturnStmt:
;!!begin MultExpr:
;!!begin and end of IdentifierExpr, passing "%uid.109" as "n"
%uid.118 = load i32* %uid.109
;!!begin FuncallOperatorExpr:
;!!begin AddExpr:
;!!begin and end of IdentifierExpr, passing "%uid.109" as "n"
%uid.121 = load i32* %uid.109
;!!begin IntegerLiteral:
%uid.123 = alloca i32
store i32 1, i32* %uid.123
;!!end IntegerLiteral:
%uid.122 = load i32* %uid.123
%uid.124 = sub i32 %uid.121, %uid.122
%uid.125 = alloca i32
store i32 %uid.124, i32* %uid.125
;!!end AddExpr:
%uid.120 = load i32* %uid.125
%uid.126 = call i32 @nfac(i32 %uid.120)
;!!end FuncalOperatorExpr
%uid.127 = alloca i32
store i32 %uid.126, i32* %uid.127
%uid.119 = load i32* %uid.127
%uid.128 = mul i32 %uid.118, %uid.119
%uid.129 = alloca i32
store i32 %uid.128, i32* %uid.129
;!!end MultExpr
%uid.130 = load i32* %uid.129
ret i32 %uid.130
br label %Label11IfteEnd
Label11IfteEnd:
;!!end ifte
}
define i32 @nfac(i32 %uid.131) {
%uid.132 = alloca i32
store i32 %uid.131, i32* %uid.132
;!!end function header
;!! IfteStmt
;!!begin EqualExpr:
;!!begin and end of IdentifierExpr, passing "%uid.132" as "n"
%uid.133 = load i32* %uid.132
;!!begin IntegerLiteral:
%uid.135 = alloca i32
store i32 0, i32* %uid.135
;!!end IntegerLiteral:
%uid.134 = load i32* %uid.135
%uid.136 = icmp ne i32 %uid.133, %uid.134
%uid.137 = alloca i1
store i1 %uid.136, i1* %uid.137
;!!end EqualExpr:
%uid.138 = load i1* %uid.137
br i1 %uid.138, label %Label12IfteTrue, label %Label13IfteFalse
Label12IfteTrue:
;!!ReturnStmt:
;!!begin MultExpr:
;!!begin FuncallOperatorExpr:
;!!begin AddExpr:
;!!begin and end of IdentifierExpr, passing "%uid.132" as "n"
%uid.141 = load i32* %uid.132
;!!begin IntegerLiteral:
%uid.143 = alloca i32
store i32 1, i32* %uid.143
;!!end IntegerLiteral:
%uid.142 = load i32* %uid.143
%uid.144 = sub i32 %uid.141, %uid.142
%uid.145 = alloca i32
store i32 %uid.144, i32* %uid.145
;!!end AddExpr:
%uid.140 = load i32* %uid.145
%uid.146 = call i32 @mfac(i32 %uid.140)
;!!end FuncalOperatorExpr
%uid.147 = alloca i32
store i32 %uid.146, i32* %uid.147
%uid.139 = load i32* %uid.147
;!!begin and end of IdentifierExpr, passing "%uid.132" as "n"
%uid.148 = load i32* %uid.132
%uid.149 = mul i32 %uid.139, %uid.148
%uid.150 = alloca i32
store i32 %uid.149, i32* %uid.150
;!!end MultExpr
%uid.151 = load i32* %uid.150
ret i32 %uid.151
br label %Label14IfteEnd
Label13IfteFalse:
;!!ReturnStmt:
;!!begin IntegerLiteral:
%uid.152 = alloca i32
store i32 1, i32* %uid.152
;!!end IntegerLiteral:
%uid.153 = load i32* %uid.152
ret i32 %uid.153
br label %Label14IfteEnd
Label14IfteEnd:
;!!end ifte
}
define double @dfac(double %uid.154) {
%uid.155 = alloca double
store double %uid.154, double* %uid.155
;!!end function header
;!! IfteStmt
;!!begin EqualExpr:
;!!begin and end of IdentifierExpr, passing "%uid.155" as "n"
%uid.156 = load double* %uid.155
;!!begin DoubleLiteral:
%uid.158 = alloca double
store double 0.0, double* %uid.158
;!!end DoubleLiteral:
%uid.157 = load double* %uid.158
%uid.159 = fcmp oeq double %uid.156, %uid.157
%uid.160 = alloca i1
store i1 %uid.159, i1* %uid.160
;!!end EqualExpr:
%uid.161 = load i1* %uid.160
br i1 %uid.161, label %Label15IfteTrue, label %Label16IfteFalse
Label15IfteTrue:
;!!ReturnStmt:
;!!begin DoubleLiteral:
%uid.162 = alloca double
store double 1.0, double* %uid.162
;!!end DoubleLiteral:
%uid.163 = load double* %uid.162
ret double %uid.163
br label %Label17IfteEnd
Label16IfteFalse:
;!!ReturnStmt:
;!!begin MultExpr:
;!!begin and end of IdentifierExpr, passing "%uid.155" as "n"
%uid.164 = load double* %uid.155
;!!begin FuncallOperatorExpr:
;!!begin AddExpr:
;!!begin and end of IdentifierExpr, passing "%uid.155" as "n"
%uid.167 = load double* %uid.155
;!!begin DoubleLiteral:
%uid.169 = alloca double
store double 1.0, double* %uid.169
;!!end DoubleLiteral:
%uid.168 = load double* %uid.169
%uid.170 = fsub double %uid.167, %uid.168
%uid.171 = alloca double
store double %uid.170, double* %uid.171
;!!end AddExpr:
%uid.166 = load double* %uid.171
%uid.172 = call double @dfac(double %uid.166)
;!!end FuncalOperatorExpr
%uid.173 = alloca double
store double %uid.172, double* %uid.173
%uid.165 = load double* %uid.173
%uid.174 = mul double %uid.164, %uid.165
%uid.175 = alloca double
store double %uid.174, double* %uid.175
;!!end MultExpr
%uid.176 = load double* %uid.175
ret double %uid.176
br label %Label17IfteEnd
Label17IfteEnd:
;!!end ifte
}
define i32 @ifac(i32 %uid.177) {
%uid.178 = alloca i32
store i32 %uid.177, i32* %uid.178
;!!end function header
;!!ReturnStmt:
;!!begin FuncallOperatorExpr:
;!!begin IntegerLiteral:
%uid.181 = alloca i32
store i32 1, i32* %uid.181
;!!end IntegerLiteral:
%uid.179 = load i32* %uid.181
;!!begin and end of IdentifierExpr, passing "%uid.178" as "n"
%uid.180 = load i32* %uid.178
%uid.182 = call i32 @ifac2f(i32 %uid.179, i32 %uid.180)
;!!end FuncalOperatorExpr
%uid.183 = alloca i32
store i32 %uid.182, i32* %uid.183
%uid.184 = load i32* %uid.183
ret i32 %uid.184
}
define i32 @ifac2f(i32 %uid.185, i32 %uid.186) {
%uid.187 = alloca i32
store i32 %uid.185, i32* %uid.187
%uid.188 = alloca i32
store i32 %uid.186, i32* %uid.188
;!!end function header
;!! IfteStmt
;!!begin EqualExpr:
;!!begin and end of IdentifierExpr, passing "%uid.187" as "l"
%uid.189 = load i32* %uid.187
;!!begin and end of IdentifierExpr, passing "%uid.188" as "h"
%uid.190 = load i32* %uid.188
%uid.191 = icmp eq i32 %uid.189, %uid.190
%uid.192 = alloca i1
store i1 %uid.191, i1* %uid.192
;!!end EqualExpr:
%uid.193 = load i1* %uid.192
br i1 %uid.193, label %Label18IfteTrue, label %Label19IfteFalse
Label18IfteTrue:
;!!ReturnStmt:
;!!begin and end of IdentifierExpr, passing "%uid.187" as "l"
%uid.194 = load i32* %uid.187
ret i32 %uid.194
br label %Label20IfteEnd
Label19IfteFalse:
br label %Label20IfteEnd
Label20IfteEnd:
;!!end ifte
;!! IfteStmt
;!!begin RelationExpr:
;!!begin and end of IdentifierExpr, passing "%uid.187" as "l"
%uid.195 = load i32* %uid.187
;!!begin and end of IdentifierExpr, passing "%uid.188" as "h"
%uid.196 = load i32* %uid.188
%uid.197 = icmp sgt i32 %uid.195, %uid.196
%uid.198 = alloca i1
store i1 %uid.197, i1* %uid.198
;!!end RelationExpr
%uid.199 = load i1* %uid.198
br i1 %uid.199, label %Label21IfteTrue, label %Label22IfteFalse
Label21IfteTrue:
;!!ReturnStmt:
;!!begin IntegerLiteral:
%uid.200 = alloca i32
store i32 1, i32* %uid.200
;!!end IntegerLiteral:
%uid.201 = load i32* %uid.200
ret i32 %uid.201
br label %Label23IfteEnd
Label22IfteFalse:
br label %Label23IfteEnd
Label23IfteEnd:
;!!end ifte
;!!begin DeclarationStmt, FieldValue == null
%uid.202 = alloca i32
;!!end DeclarationStmt
;!!begin AssignmentExpr:
;!!begin MultExpr:
;!!begin AddExpr:
;!!begin and end of IdentifierExpr, passing "%uid.187" as "l"
%uid.204 = load i32* %uid.187
;!!begin and end of IdentifierExpr, passing "%uid.188" as "h"
%uid.205 = load i32* %uid.188
%uid.206 = add i32 %uid.204, %uid.205
%uid.207 = alloca i32
store i32 %uid.206, i32* %uid.207
;!!end AddExpr:
%uid.203 = load i32* %uid.207
;!!begin IntegerLiteral:
%uid.209 = alloca i32
store i32 2, i32* %uid.209
;!!end IntegerLiteral:
%uid.208 = load i32* %uid.209
%uid.210 = udiv i32 %uid.203, %uid.208
%uid.211 = alloca i32
store i32 %uid.210, i32* %uid.211
;!!end MultExpr
;!!begin and end of IdentifierExpr, passing "%uid.202" as "m"
%uid.212 = load i32* %uid.211
store i32 %uid.212, i32* %uid.202
;!!end AssignmentExpr:
;!!ReturnStmt:
;!!begin MultExpr:
;!!begin FuncallOperatorExpr:
;!!begin and end of IdentifierExpr, passing "%uid.187" as "l"
%uid.214 = load i32* %uid.187
;!!begin and end of IdentifierExpr, passing "%uid.202" as "m"
%uid.215 = load i32* %uid.202
%uid.216 = call i32 @ifac2f(i32 %uid.214, i32 %uid.215)
;!!end FuncalOperatorExpr
%uid.217 = alloca i32
store i32 %uid.216, i32* %uid.217
%uid.213 = load i32* %uid.217
;!!begin FuncallOperatorExpr:
;!!begin AddExpr:
;!!begin and end of IdentifierExpr, passing "%uid.202" as "m"
%uid.221 = load i32* %uid.202
;!!begin IntegerLiteral:
%uid.223 = alloca i32
store i32 1, i32* %uid.223
;!!end IntegerLiteral:
%uid.222 = load i32* %uid.223
%uid.224 = add i32 %uid.221, %uid.222
%uid.225 = alloca i32
store i32 %uid.224, i32* %uid.225
;!!end AddExpr:
%uid.219 = load i32* %uid.225
;!!begin and end of IdentifierExpr, passing "%uid.188" as "h"
%uid.220 = load i32* %uid.188
%uid.226 = call i32 @ifac2f(i32 %uid.219, i32 %uid.220)
;!!end FuncalOperatorExpr
%uid.227 = alloca i32
store i32 %uid.226, i32* %uid.227
%uid.218 = load i32* %uid.227
%uid.228 = mul i32 %uid.213, %uid.218
%uid.229 = alloca i32
store i32 %uid.228, i32* %uid.229
;!!end MultExpr
%uid.230 = load i32* %uid.229
ret i32 %uid.230
}
