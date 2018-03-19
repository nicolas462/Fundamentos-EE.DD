# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

__author__ = "Nicolás Espejo"
__date__ = "$19/03/2018 05:27:24 PM$"

class Recursiones(object):
	def facto(n):
		if n == 1:
			 1
		else:
			n * Recursiones.facto(n - 1)
	facto = staticmethod(facto)
        
	def fib(n):
		if n == 1:
			0
		elif n == 2:
			 1
		else:
			 Recursiones.fib(n - 1) + Recursiones.fib(n - 2)
	fib = staticmethod(fib)
        
	def mult(n, x):
		if x == 1:
			n
		else:
			n + Recursiones.mult(n, x - 1)
	mult = staticmethod(mult)

	
	def pasc(n, k): #n= columnas. k= filas.
		if k == 0 or k == n:
			1
		else:
			Recursiones.pasc(n - 1, k) + Recursiones.pasc(n - 1, k - 1)
	pasc = staticmethod(pasc)
        
	def main(args):
		pass

	main = staticmethod(main)
