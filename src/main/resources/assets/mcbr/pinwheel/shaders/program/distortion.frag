#version 150

in vec2 fragUV;
out vec4 FragColor;

uniform sampler2D Texture;
uniform float Time;

void main() {
    vec2 distortedUV = fragUV + vec2(sin(Time + fragUV.y * 10.0) * 0.05, 0.0);
    FragColor = texture(Texture, distortedUV);
}