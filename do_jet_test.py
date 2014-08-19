#!/usr/bin/python2.7
# -*- coding: UTF-8 -*-


import sys, os, subprocess

launchdir = os.getcwd()

#dirlist = [, os.path.join(launchdir,'JETcompiler/Tests/bad')]#, os.path.join(launchdir, 'JETcompiler/Tests/extensions')]


#good:
directory = os.path.join(launchdir,'JETcompiler/Tests/good') 

print('Przetwarzam testy z katalogu good:')
filelist = [f for f in os.listdir(directory) if (os.path.isfile(os.path.join(directory, f)) and f.endswith('.jl'))]
filelist = sorted(filelist)
for fname in filelist:
	res = subprocess.check_output(['java', '-jar', './jc.jar', os.path.join(directory, fname)])
	if(res == 'Program is correct.\n'):
		print('program ' + fname + ': OK')
	else:
		print('test "' + fname + '" ends with error:\n' + res)
	
	#f = open(os.path.join(directory, fname[:-3] + '.myout'), 'w+')
	#f.write(res)
	#f.close()


directory = os.path.join(launchdir,'JETcompiler/Tests/bad') 
print('Przetwarzam testy z katalogu bad:')
filelist = [f for f in os.listdir(directory) if (os.path.isfile(os.path.join(directory, f)) and f.endswith('.jl'))]
filelist = sorted(filelist)
for fname in filelist:
	res = subprocess.check_output(['java', '-jar', './jc.jar', os.path.join(directory, fname)])

	try:
		expected_output = open(os.path.join(directory, fname[:-3] + '.myout'), 'r')
		expected_res = expected_output.read()
		expected_output.close()

	
		if(res == expected_res):
			print('program ' + fname + ' is wrong as expected.')
		else:
			print('test "' + fname + '" ends with error:\nexpected output is:\n' + expected_res + '\nand received output is:\n' + res)
	except IOError:
		print('there is no expected output for this program. A new output is being saved as a reference. It looks like this:')
		print(res)
		f = open(os.path.join(directory, fname[:-3] + '.myout'), 'w+')
		f.write(res)
		f.close()

print('Zaczynam testy klas:')

directory = os.path.join(launchdir,'JETcompiler/Tests/classes/good') 
print('Przetwarzam testy z katalogu classes/good:')
filelist = [f for f in os.listdir(directory) if (os.path.isfile(os.path.join(directory, f)) and f.endswith('.jl'))]
filelist = sorted(filelist)
for fname in filelist:
	output_filename = os.path.join(directory, fname[0:-3] + ".ll")
	res = subprocess.check_output(['java', '-jar', './jc.jar', os.path.join(directory, fname), '-o', output_filename])

	if(res == 'Program is correct.\n'):
		print('program ' + fname + ': code generation OK')
		print('compiling:...')
		comres = subprocess.check_output(['llvm-as', output_filename])
		print(comres)
		print('linking...')
		linkres = subprocess.check_output(['llvm-ld', output_filename[:-3]+'.bc', 'runtime.bc'])
		print(linkres)
	else:
		print('test "' + fname + '" ends with error:\n' + res)


