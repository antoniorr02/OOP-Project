# encoding:utf-8

class Parcela

    @nombre
    @precioCompra
    @precioEdificar
    @precioBaseAlquiler = 0
    @numCasas = 0
    @numHoteles = 0

#Getters:
    def self.nombre
        @nombre
    end

    def self.precioCompra
        @precioCompra
    end

    def self.precioEdificar
        @precioEdificar
    end

    def self.precioBaseAlquiler
        @precioBaseAlquiler
    end

    def self.numCasas
        @numCasas
    end

    def numHoteles
        @numHoteles
    end

#Setters:

    def self.set_nombre(nombre)
        @nombre = nombre
    end

    def self.set_precioCompra(precioCompra)
        @precioCompra = precioCompra
    end

    def self.set_precioEdificar(precioEdificar)
        @precioEdificar = precioEdificar
    end

    def self.set_precioBaseAlquiler(precioBaseAlquiler)
        @nombre = precioBaseAlquiler
    end

#Methods:
    
    def self.construir_casa
        @numCasas += 1
    end

    def self.construir_hotel
        @numHoteles += 1
    end

    def self.getPrecioAlquilerCompleto
        puts @precioBaseAlquiler * (1 + @numCasas*1 + @numHoteles*4)
    end
end

Parcela.construir_casa
Parcela.construir_hotel
Parcela.set_precioBaseAlquiler(10)
puts Parcela.precioBaseAlquiler
Parcela.getPrecioAlquilerCompleto