# encoding:utf-8

class Parcela
    def initialize(nombre, precioCompra, precioEdificar, precioBaseAlquiler)
        @nombre = nombre
        @precioCompra = precioCompra
        @precioEdificar = precioEdificar
        @precioBaseAlquiler = precioBaseAlquiler
        @numCasas = 0
        @numHoteles = 0
    end

    def nombre
        @nombre
    end

    def precioCompra
        @precioCompra
    end

    def precioEdificar
        @precioEdificar
    end

    def precioBaseAlquiler
        @precioBaseAlquiler
    end

    def numCasas
        @numCasas
    end

    def numHoteles
        @numHoteles
    end

    def contruir_casa
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
parcela.contruirCasa()
parcela.construirHotel()
parcela.getPrecioAlquilerCompleto()