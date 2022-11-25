require_relative "Deportistas"
module Herencia
    class Corredor_Nadador < Deportistas

        def initialize(deportista, t)
            super(deportista.nombre, deportista.horas_entrenamiento)
            @tipo = t
        end

        def competicion_deportiva_completa(horas)
            result = "#{competicion_deportiva(horas)}, es #{@tipo}.\n\n"
            return result
        end

    end
end