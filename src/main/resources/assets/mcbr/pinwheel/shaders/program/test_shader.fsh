uniform sampler2D DiffuseSampler;
uniform float time;
in vec2 texCoord;
out vec4 fragColor;


out vec4 FragColor;
uniform vec4 uColor;

void main() {
    FragColor = uColor;
}