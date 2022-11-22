require_relative "Deportistas"
module Herencia
    class Corredor < Deportistas

        def initialize(deportista)
            @padre2 = super(deportista.nombre, deportista.horas_entrenamiento)
        end

        def competicion_deportiva_completa
            result = "#{@padre2.competicion_deportiva(@padre2.horas_entrenamiento)}, es corredor."
            return result
        end

    end
end