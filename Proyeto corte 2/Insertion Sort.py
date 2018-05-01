""" Se ordenarán datos de un arreglo recibidos por consola
con el algoritmo 'Insertion Sort'"""
def insertionSort (a):
	x = 0
	index = 0
	for i in range (0, len(a)):
		#Seleccionar valor para mover
		x = a[i] #Se guarda el valor en una variable porque después se usará.
		index = i #Se guarda i en una variable porque se restarán valores.
		#Localizar posición vacía para insertar valor
		while index > 0 and a[index-1] > x :
			a[index] = a[index - 1] #Se reemplaza el número por el número anterior a éste.
			index -= 1
		#Insertar el valor en la posición vacía. Se usa el valor que se guardó anteriormente.
		a[index] = x

print ("Ingrese números: ")
a = input()
list = a.split(",") #Se dividen los valores por comas y se guardan en una lista.
enteros = [] #Se guardarán enteros
for i in range(0, len(list)): #Pasar str a int
	enteros.append(int (list[i]))
	
insertionSort(enteros) #Se llama a la función
print ("Arreglo ordenado :", enteros )
