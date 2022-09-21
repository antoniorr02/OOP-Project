#!/usr/bin/env ruby

class Parcela
    def initialize(nombre, precioCompra, precioEdificar, precioBaseAlquiler)
        @nombre = nombre
        @precioCompra = precioCompra
        @precioEdificar = precioEdificar
        @precioBaseAlquiler = precioBaseAlquiler
        @numCasas = 0
        @numHoteles = 0
    end

    def getNombre() 
        @nombre
    end

    def getPrecioCompra()
        @precioCompra
    end

    def getPrecioEdificar()
        @precioEdificar
    end

    def getPrecioBaseAlquiler()
        @precioBaseAlquiler
    end

    def getNumCasas()
        @numCasas
    end

    def getNumHoteles()
        @numHoteles
    end

    def contruirCasa()
        @numCasas += 1
    end

    def construirHotel()
        @numHoteles += 1
    end

    def getPrecioAlquilerCompleto() 
        puts @precioBaseAlquiler * (1 + @numCasas*1 + @numHoteles*4)
    end
end

parcela = Parcela.new("nombre", 10, 20,5)
parcela.contruirCasa()
parcela.construirHotel()
parcela.getPrecioAlquilerCompleto()