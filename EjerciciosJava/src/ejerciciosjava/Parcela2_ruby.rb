# encoding:utf-8

class Parcela
    attr_accessor :nombre, :precioCompra, :precioEdificar, :precioBaseAlquiler, :numCasas, :numHoteles

    def initialize(nombre, precioCompra, precioEdificar, precioBaseAlquiler)
        @nombre = nombre
        @precioCompra = precioCompra
        @precioEdificar = precioEdificar
        @precioBaseAlquiler = precioBaseAlquiler
        @numCasas = 0
        @numHoteles = 0
    end

    def construir_casa
        @numCasas += 1
    end

    def construir_hotel
        @numHoteles += 1
    end

    def getPrecioAlquilerCompleto
        puts @precioBaseAlquiler * (1 + @numCasas*1 + @numHoteles*4)
    end
end

parcela = Parcela.new("nombre", 10, 20,5)
parcela.construir_casa()
parcela.construir_hotel()
parcela.getPrecioAlquilerCompleto()