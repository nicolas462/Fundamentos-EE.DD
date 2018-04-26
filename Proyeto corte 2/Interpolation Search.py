""" Buscar un valor en un arreglo con el algoritmo de 'Interpolation Search'"""
def interpolationSearch (A, x):
	lowerBound = 0
	upperBound = len (A) -1
	index = -1
	#Si el límite superior es menor que el inferior, no hay una solución factible. 
	while lowerBound < upperBound:
		middlePoint = lowerBound + ((upperBound-lowerBound)//(A[upperBound] - A[lowerBound])) * (x - A[lowerBound])
		if x == A [middlePoint]:
			#El valor ha sido encontrado. 
			index = middlePoint
			break
		elif x < A[middlePoint]:
			upperBound = middlePoint -1
		else:
			lowerBound = middlePoint + 1
	if lowerBound == upperBound and A[lowerBound] == x:
		index = lowerBound
	return index

print ("Ingrese números: ")
line = input()
lista = line.split (",")
enteros = [] #Se guardarán enteros
for i in range(0, len(lista)): #Pasar str a int
	enteros.append(int (lista[i]))

print ("Ingrese número a buscar: ")
x = int (input())
if (interpolationSearch(enteros, x) != -1):
	print ("El número está en el índice: ", interpolationSearch(enteros, x))
else:
	print ("No se encontró el número.")
