require_relative "Persona"
module Herencia
    class Deportistas < Persona

        def initialize(nombre, horas)
            super(nombre)
            @horas_entrenamiento = horas
        end

        def competicion_deportiva(horas)
            @horas_entrenamiento = horas
            result = "#{to_s} es deportista y entrena un total de #{@horas_entrenamiento} horas diarias"
            return result
        end

        def horas_entrenamiento
            @horas_entrenamiento
        end

    end
end