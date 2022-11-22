module Herencia
    class Persona

        def initialize(nombre)
            @nombre=nombre
        end

        def andar
            result = "Soy #{@nombre} y estoy andando"
            return result
        end

        def to_s
            result = "Soy una persona y mi nombre es #{@nombre}"
            return result
        end

        def nombre 
            @nombre
        end

    end
end