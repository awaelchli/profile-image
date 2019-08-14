import os
from colorsys import hsv_to_rgb

import matplotlib.pyplot as plt
import numpy as np
from numpy import pi


def f(z):
    """ Inspired by:
        https://en.wikipedia.org/wiki/Complex_analysis#/media/File:Color_complex_plot.jpg
    """
    return (z ** 2 - 1) * (z - 2 - 1j) ** 2 / (z ** 2 + 2 + 2j)


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


def main(height=128):
    rgb = plot(f, size=(height, height), domain=(-2., 2.))
    rgb = np.flip(rgb, 0)
    plt.imsave('profile-image.png', rgb)


def animation(folder='./animation', num_frames=5, height=128):
    os.makedirs(folder, exist_ok=True)
    steps = np.linspace(0, 2 * pi, num_frames + 1)

    for i, phi in enumerate(steps[:-1]):

        print(f'Generating frame {i}')

        def g(z):
            return (np.cos(phi) + 1j * np.sin(phi)) * f(z)

        rgb = plot(g, size=(height, height), domain=(-2., 2.))
        rgb = np.flip(rgb, 0)
        plt.imsave(os.path.join(folder, f'{i:03d}.png'), rgb)


if __name__ == '__main__':
    main(height=1024)
    animation(num_frames=50, height=128)
