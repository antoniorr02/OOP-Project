# encoding:utf-8

class Parcela

    @nombre
    @precioCompra
    @precioEdificar
    @precioBaseAlquiler = 0
    @numCasas = 0
    @numHoteles = 0

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
Parcela.instance_variable_set(:@precioBaseAlquiler, 10)
puts Parcela.instance_variable_get(:@precioBaseAlquiler)
Parcela.getPrecioAlquilerCompleto