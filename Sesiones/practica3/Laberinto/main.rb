def prueba
    lab = Laberinto.new
    controlador = Controlador.new(lab)
    controlador.entrar(5)
    controlador.intentar_avanzar
end