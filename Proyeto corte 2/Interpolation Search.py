""" Buscar un valor en un arreglo con el algoritmo de 'Interpolation Search'"""

def interpolationSearch(a, x):
	lowerBound = 0
	upperBound = len (a) -1
	index = -1
	part1 = (upperBound - lowerBound)
	part2 = (int (a[upperBound]) - int (a[lowerBound]))
	part3 = int (x) - int (a[lowerBound])
	#Si el límite superior es menor que el inferior, no hay una solución factible. 
	while lowerBound < upperBound:
		middlePoint = int (lowerBound + (part1 / part2) * part3)
		if x == a[middlePoint]:
			#El valor ha sido encontrado. 
			index = middlePoint
			break
		elif x < a[middlePoint]:
			upperBound = middlePoint -1
		else:
			lowerBound = middlePoint + 1
	if lowerBound == upperBound and a[lowerBound] == x:
		index = lowerBound
	return index


print ("Ingrese números: ")
a = input()
print ("Ingrese número a buscar: ")
x = input()
list = a.split(",") #Se dividen los valores por comas y se guardan en una lista.
indice = interpolationSearch(list, x) #Se guarda el valor de la función.
if (indice >= 0):
	print ("El número está en el índice: ", indice, "\n")
else:
	print ("El número no se encontró.\n")
