#version 150

in vec3 Position;
in vec2 UV;

out vec2 fragUV;

uniform mat4 ModelViewProjectionMatrix;

void main() {
    fragUV = UV;
    gl_Position = ModelViewProjectionMatrix * vec4(Position, 1.0);
}
