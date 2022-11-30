require_relative "Persona"
module Herencia
    class Deportista < Persona

        def initialize(nombre, horas)
            super(nombre)
            @horas_entrenamiento = horas
        end

        def to_s
            result = "#{super}, además soy deportista y entreno un total de #{@horas_entrenamiento} horas diarias"
            return result
        end

        def horas_entrenamiento
            @horas_entrenamiento
        end

        def competicion_deportiva
            result = "#{@nombre} está compitiendo"
            return result
        end

    end
end