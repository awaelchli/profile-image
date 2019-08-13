from colorsys import hsv_to_rgb

import matplotlib.pyplot as plt
import numpy as np
from numpy import pi


def plot(func, size=(128, 128), domain=(-1., 1.)):
    xs = np.linspace(*domain, size[1])
    ys = np.linspace(*domain, size[0])
    x, y = np.meshgrid(xs, ys)
    z = x + y * 1j

    values = func(z)
    arg = np.angle(values)
    arg = np.where(arg < 0, arg + 2 * pi, arg)
    hue = arg / (2 * pi)

    hsv = np.vectorize(hsv_to_rgb)
    r, g, b = hsv(hue, s=1., v=1.)
    rgb = np.stack((r, g, b), -1)
    return rgb


def main():
    """ Inspired by:
        https://de.wikipedia.org/wiki/Funktionentheorie#/media/Datei:Color_complex_plot2.jpg
    """

    def f(z):
        return (z ** 2 - 1) * (z - 2 - 1j) ** 2 / (z ** 2 + 2 + 2j)

    rgb = plot(f, size=(1024, 1024), domain=(-2., 2.))
    rgb = np.flip(rgb, 0)
    plt.imsave('profile-image.png', rgb)


if __name__ == '__main__':
    main()
